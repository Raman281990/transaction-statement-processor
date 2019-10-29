# transaction-statement-processor
This Application processes the transaction statements and generates report of failed records

Rabobank receives monthly deliveries of customer statement records. This information is delivered in two formats, CSV and XML. These records need to be validated.

## Input
The format of the file is a simplified version of the MT940 format. The format is as follows:

Table 1. Record description
Field	Description

Transaction reference A numeric value

Account number

An IBAN

Start Balance The starting balance in Euros

Mutation Either an addition (+) or a deduction (-)

Description

Free text

End Balance The end balance in Euros

## Output:

There are two validations:

all transaction references should be unique

the end balance needs to be validated

At the end of the processing, a report needs to be created which will display both the transaction reference and description of each of the failed records.

## Technologies Used

1) Java8
2) Spring boot
3) Spring batch
4) Mysql
5) Docker

## Steps to run the application

1) Build:
  mvn clean install
  
2) run Mysql on Docker :

    docker-compose up
    
3) run batch_Scripts.sql file from the mysql_Scripts directory for spring batch tables.

4) For running the application use: 

  mvn spring-boot:run -Dspring-boot.run.profiles=dev
  
 ## Api 
 
 http://localhost:8095/transaction-statements/process
 
 Get Method
 
 Response:
 
 DESCRIPTION,REFERENCEID
 
 Subscription for Erik Dekker,189177
 
 Subscription for Erik Theuß,163215

 It return the csv response which can be saved from postman, send and download button.
 
 ## Implementation
 
 Spring batch processes the records from the xml file and validates the records and saves the valid record in the database
 and saves the inValid records in the Job Execution Context.
 
 Once the Batch completes, then CSV data is generated for the failed records.
 
 Valid Records are saved in TransactionStatement table.
 



