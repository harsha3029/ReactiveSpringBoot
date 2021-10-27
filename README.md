# ReactiveSpringBoot

Reactive Spring app to insert student details into DB and read it  
data.sql -> add as many as inserts to create list of students in the default h2 database - It gets executed upon each restart of spring boot app
Run the app- > In the IDE console you will see the reactive spring boot response 
" Hibernate: Select * from student
Srinivas:Mekala:srinu@gmail.com:USA:1234568900 "
of student details even with out accessing the application URL, which means each 
StudentRouter class routes any request http://localhost:8080/findStudents from StudentClient(WebClient) to the  StudentHandler 
and retrives the values of toString() method of StudentDTO pojo
making a call to DB via StudentController, StudentService, StudentServiceImpl, StudentDO

Output:

On the console you will see this Srinivas:Mekala:srinu@gmail.com:USA:1234568900 -> This is the response from ReactiveSpringBoot
On the other hand access http://localhost:8080/findStudents and you should see the normal spring boot rest api response.
