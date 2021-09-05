import java.io.*;
import java.sql.*;

public class JavaWebApplication 
{
    public static void main(String[] args) 
    {
        try 
        {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create a connection
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url,username,password);

            System.out.println("\n\n\t\t+--------------------------------------------------------+");
            System.out.println("\t\t|\tWelcome to Student Management Application        |");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                
                System.out.println("\t\t+--------------------------------------------------------+");
                System.out.println("\t\t|    Press 1 to ADD Student Info                         |");
                System.out.println("\t\t|    Press 2 to Update the Student Info                  |");
                System.out.println("\t\t|    Press 3 to DISPLAY Student Info                     |");
                System.out.println("\t\t|    Press 4 to Display Student info using stdId         |");
                System.out.println("\t\t|    Press 5 to Prepare the Marksheet of the Student     |");
                System.out.println("\t\t|    Press 6 to Update Marksheet of the Student          |");
                System.out.println("\t\t|    Press 7 to Display the Marksheet using stdId        |");
                System.out.println("\t\t|    Press 8 to Display the Marksheet of all Students    |");
                System.out.println("\t\t|    Press 9 to Exit from Application                    |");
                System.out.println("\t\t+--------------------------------------------------------+\n\n");
                System.out.print("Input - ");
                int c = Integer.parseInt(br.readLine());

                if(c==1) {
                    //create a query
                    String q1 = "insert into students(stdId, name, class, section, address) values(?,?,?,?,?)";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q1);
        
                    System.out.println("Enter the Name : ");
                    String name = br.readLine();
        
                    System.out.println("Enter the Address : ");
                    String address = br.readLine();

                    System.out.println("Enter the section : ");
                    String section = br.readLine();

                    System.out.println("Enter the Student's Id : ");
                    int stdId = Integer.parseInt(br.readLine());

                    System.out.println("Enter Class ");
                    int Class = Integer.parseInt(br.readLine());
        
                    //set the values to query
                    pstmt.setInt(1,stdId);
                    pstmt.setString(2,name);
                    pstmt.setInt(3,Class);
                    pstmt.setString(4,section);
                    pstmt.setString(5,address);
        
                    pstmt.executeUpdate();
        
                    System.out.println("\nInserted...\n\n");

                }
				
                else if(c==2)
                {
                    //create a query
                    String q2 = "update students set name = ?, class = ?, section = ?, address = ? where stdId = ?";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q2);
                    
                    System.out.println("Enter the name : ");
                    String name = br.readLine();
        
                    System.out.println("Enter the address : ");
                    String address = br.readLine();
        
                    System.out.println("Enter section : ");
                    String section = br.readLine();
                    System.out.println("Enter the class");
                    int Class = Integer.parseInt(br.readLine());
        
                    System.out.println("Enter the stdId");
                    int stdId = Integer.parseInt(br.readLine());
        
                    //set the values to query
                    pstmt.setString(1,name);
                    pstmt.setInt(2,Class);
                    pstmt.setString(3,section);
                    pstmt.setString(4,address);
                    pstmt.setInt(5,stdId);
        
                    pstmt.executeUpdate();
        
                    System.out.println("Updated...\n\n");
                }
				
                else if(c==3)
                 {
                    //display students;
                    // create a query

                    String q3 = "select * from students";

                    Statement stmt = con.createStatement();
                    ResultSet set = stmt.executeQuery(q3);
                    System.out.println("\t+-----------------------------------------------------------------------------------------------+");
                    System.out.println("\t|\t stdId           Name           Class         Section             Address               |");
                    System.out.println("\t+-----------------------------------------------------------------------------------------------+");
                    
                    while(set.next())
                    {
                        int stdId = set.getInt("stdId");
                        String name = set.getString("name");
                        int Class = set.getInt("class");
                        String section = set.getString("section");
                        String address = set.getString("address");
                        
                        System.out.println("\t|\t"+ stdId + "\t " + name + "\t\t " + Class + "\t\t " + section + "\t\t" + address );
                    }
                    System.out.println("\t+-----------------------------------------------------------------------------------------------+\n\n");
                }
				
                else if(c==9) 
                {
                    //exit from application;
                    break;
                }
				
                else if(c==4)
                {
                    String q4 = "select * from students where stdId = ?";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q4);
                    
                    System.out.println("Enter the stdId : ");
                    int stdId = Integer.parseInt(br.readLine());

                    pstmt.setInt(1, stdId);
                    
                    ResultSet set = pstmt.executeQuery();
                    
                    while (set.next()) {
                        System.out.println(set.getInt("stdId") + 
							"\t " + set.getString("name") + 
							"\t\t " + set.getInt("class") + 
							"\t " + set.getString("section") + 
							"\t" + set.getString("address"));
                    }
                } 
				
                else if(c==5)
                {
                    //create a query
                    String q5 = "insert into results(stdId, Hindi, English, Maths, Science, SST, Sanskrit) values(?,?,?,?,?,?,?)";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q5);

                    System.out.println("Enter the Student's Id : ");
                    int stdId = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Hindi : ");
                    int Hindi = Integer.parseInt(br.readLine());
        
                    System.out.println("Enter marks in English : ");
                    int English = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Maths : ");
                    int Maths = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Science : ");
                    int Science = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in SST : ");
                    int SST = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Sanskrit : ");
                    int Sanskrit = Integer.parseInt(br.readLine());

                    //set the values to query
                    pstmt.setInt(1,stdId);
                    pstmt.setInt(2,Hindi);
                    pstmt.setInt(3,English);
                    pstmt.setInt(4,Maths);
                    pstmt.setInt(5,Science);
                    pstmt.setInt(6,SST);
                    pstmt.setInt(7,Sanskrit);
        
                    pstmt.executeUpdate();
        
                    System.out.println(" ");
                    System.out.println("Inserted...");
                    System.out.println(" ");
                }
				
                else if(c==6)
                {
                    String q6 = "update results set Hindi = ?, English = ?, Maths = ?, Science = ?, SST = ?, Sanskrit = ? where stdId = ?";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q6);
                    
                    System.out.println("Enter marks in Hindi : ");
                    int Hindi = Integer.parseInt(br.readLine());
        
                    System.out.println("Enter marks in English : ");
                    int English = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Maths : ");
                    int Maths = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Science : ");
                    int Science = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in SST : ");
                    int SST = Integer.parseInt(br.readLine());

                    System.out.println("Enter marks in Sanskrit : ");
                    int Sanskrit = Integer.parseInt(br.readLine());
        
                    System.out.println("Enter the Student's Id : ");
                    int stdId = Integer.parseInt(br.readLine());

                    //set the values to query
                    pstmt.setInt(1,Hindi);
                    pstmt.setInt(2,English);
                    pstmt.setInt(3,Maths);
                    pstmt.setInt(4,Science);
                    pstmt.setInt(5,SST);
                    pstmt.setInt(6,Sanskrit);
                    pstmt.setInt(7,stdId);
        
                    pstmt.executeUpdate();
        
                    System.out.println("Updated...");
                }
				
                else if(c==7)
                {
                    String q7 = "select * from results where stdId = ?";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q7);
                    
                    System.out.println("Enter the stdId : ");
                    int stdId = Integer.parseInt(br.readLine());

                    pstmt.setInt(1, stdId);
                    
                    ResultSet set = pstmt.executeQuery();
                    
                    while (set.next()) {
                        System.out.println(set.getInt("stdId") +
                         "\t " + set.getInt("Hindi") +
                         "\t " + set.getInt("English") +
                         "\t " + set.getInt("Maths") +
                         "\t " + set.getInt("Science") +
                         "\t " + set.getInt("SST") + 
                         "\t " + set.getInt("Sanskrit"));
                    }
                }
				
                else if(c==8)
                {
                    String q8 = "select * from results";

                    Statement stmt = con.createStatement();
                    ResultSet set = stmt.executeQuery(q8);
        
                    System.out.println("\tMarksheet:- ");
                    System.out.println("\n\t+--------------------------------------------------------------+");
                    System.out.println("\t|  stdId   Hindi   English   Maths   Science   SST   Sanskrit  |");
                    System.out.println("\t+--------------------------------------------------------------+");
                    
                    while(set.next())
                    {
                        int stdId = set.getInt("stdId");
                        int Hindi = set.getInt("Hindi");
                        int English = set.getInt("English");
                        int Maths = set.getInt("Maths");
                        int Science = set.getInt("Science");
                        int SST = set.getInt("SST");
                        int Sanskrit = set.getInt("Sanskrit");
                        
                        System.out.println("\t| " + stdId + "   " + Hindi + "        " + English + "      " + Maths + "       " + Science + "     " + SST + "       " + Sanskrit + "     |");
                    }
                    System.out.println("\t+--------------------------------------------------------------+");
                    System.out.println("\n\n");
                }
				
                else
                {
                    System.out.println("!Invalid Input");
                }
				
            }

            System.out.println("Thank you for using my application....");
            System.out.println("See you soon.");

            con.close();
        } 
		
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		
    }
	
}
