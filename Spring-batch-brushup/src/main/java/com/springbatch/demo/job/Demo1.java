package com.springbatch.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.springbatch.demo.dto.EmployeeDTO;
import com.springbatch.demo.mapper.EmployeeFileRowMapper;
import com.springbatch.demo.model.Employee;
import com.springbatch.demo.processor.EmployeeProcessor;

import javax.sql.DataSource;

@Configuration
public class Demo1 {

	private JobBuilderFactory jobBuilderFactory;
	private StepBuilderFactory stepBuilderFactory;
	private EmployeeProcessor employeeProcessor;
	private DataSource dataSource;

	@Autowired
	public Demo1(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			EmployeeProcessor employeeProcessor, DataSource dataSource) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.employeeProcessor = employeeProcessor;
		this.dataSource = dataSource;
	}

	/*
	 * application starts from here.Here JobBuilderFactory class is used to create
	 * Job interface's object
	 */
	@Qualifier(value = "demo1")
	@Bean
	public Job demo1Job() throws Exception {
		return this.jobBuilderFactory.get("demo1").start(step1Demo1())
				// .next(step2Demo2) //if we have multiple steps
				.build();
	}

	/*
	 * Step is a combo of reader, processor and writer. StepBuilderFactory is used
	 * here to create step's object
	 */
	@Bean
	public Step step1Demo1() throws Exception {
		return this.stepBuilderFactory.get("step1")
				.<EmployeeDTO, Employee>chunk(5) /*It will process and write 5 records from the file at a time*/
				.reader(employeeReader()) /** using FaltFileIteamReader here*/
				.processor(employeeProcessor).writer(employeeDBWriterDefault()).build();
	}

	@Bean
	@StepScope
	/**
	 * with the help of jobParameter provided by spring, we can set the resource
	 * value (File name) at runtime as well
	 */
	Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName) throws Exception {
		return new ClassPathResource(fileName);
	}

	@Bean
	@StepScope
	/**
	 * @StepScope means that Spring Batch will use the spring container to
	 *            instantiate a new instance of that component for each step
	 *            execution.
	 */
	public FlatFileItemReader<EmployeeDTO> employeeReader() throws Exception {
		FlatFileItemReader<EmployeeDTO> reader = new FlatFileItemReader<>();
		reader.setResource(inputFileResource(null));
		/**
		 * with the help of jobParameter provided by spring, we can set the resource
		 * value (File name) at runtime as well
		 */
		reader.setLineMapper(new DefaultLineMapper<EmployeeDTO>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames("employeeId", "firstName", "lastName", "email",
								"age"); /** column names in our input file */
						setDelimiter(","); /** based on the input file data separation */
					}
				});
				setFieldSetMapper(new EmployeeFileRowMapper()); /** set our FileRowMapper */
			}
		});
		return reader;
	}

	// Using JdbcBatchItemWriter to write the data into our DB
	@Bean
	public JdbcBatchItemWriter<Employee> employeeDBWriterDefault() {
		JdbcBatchItemWriter<Employee> itemWriter = new JdbcBatchItemWriter<Employee>();
		itemWriter.setDataSource(dataSource); // Setting the dataSource object here
		itemWriter.setSql(
				"insert into employee (employee_id, first_name, last_name, email, age) values (:employeeId, :firstName, :lastName, :email, :age)");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return itemWriter;
	}

}
