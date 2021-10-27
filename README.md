# ReactiveSpringBoot

Reactive Spring app to insert student details into DB and read it and write it into the Students.csv file in the project path 
data.sql -> add as many as inserts to create list of students in the default h2 database - It gets executed upon each restart of spring boot app and gets deleted when terminated.


Run the app- > Output : You can see it in the Students.csv file in the project path.

Flow: 

StudentRouter class routes any request for /findStudents from StudentClient(WebClient) to the  StudentHandler 
and retrives the values from db making a call to DB via StudentController, StudentService, StudentServiceImpl, StudentDO and prepares List<StudentDTO> 
  and another call /exportCSV will happen post above to write the list of Students from DB into Students.csv


