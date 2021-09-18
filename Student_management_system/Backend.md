<h3><b>BackEnd</b></h3>
<hr>
<p>
	To create a backend of the <b>Student Management System</b>, we have to follow these steps:-
	<ul>
		<li>First we have to have a <b>MySQL</b> installed in the pc or computer.</li>
		<li>Second thing we needed is a <b>Command Line Client of MySQL</b> or one can use the <b>Workbench</b>.</li>
		<li>Now, in command line client first <b>enter the password</b>(by default it is <b>root</b>).</li>
		<li>Check whether a database named "test" exist or not</li>
		<li>If not then create it by writing "create database test;".</li>
		<li>To use the test database write "use test".</li>
		<li>To store the information of the students we have to create a table named "students" having following fields :-</li>
		<ol>
			<li>stdId &nbsp; &nbsp; &nbsp; int(8) &nbsp; &nbsp; &nbsp; primary key</li>
			<li>name &nbsp; &nbsp; &nbsp; varchar(25)	</li>
			<li>class  &nbsp; &nbsp; &nbsp; int(11)	</li>
			<li>section &nbsp; &nbsp; &nbsp; varchar(1)	</li>
			<li>address &nbsp; &nbsp; &nbsp; varchar(100)	</li>
		</ol>
		<li>To store the marks of students in every subject we have to create a table named "results" having following fields :-</li>
		<ol>
			<li>stdId &nbsp; &nbsp; &nbsp; int(8) &nbsp; &nbsp; &nbsp; primary key	</li>
			<li>Hindi &nbsp; &nbsp; &nbsp; int(11)	</li>
			<li>English &nbsp; &nbsp; &nbsp; int(11)	</li>
			<li>Maths &nbsp; &nbsp; &nbsp; int(11)	</li>
			<li>Science &nbsp; &nbsp; &nbsp; int(11)	</li>
			<li>SST &nbsp; &nbsp; &nbsp; int(11)	</li>
			<li>Sanskrit &nbsp; &nbsp; &nbsp; int(11)	</li>
		</ol>
	</ul>
	Congratulations your backend is ready.<br>
	<hr>
	Thanks for visiting and do star the repo if you like it.
</p>
