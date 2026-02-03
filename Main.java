import java.util.Scanner;
public class FP1{
    //1
    public static void inputMarks(String []subjectNames, String []studentNames, int [][]marks){
       Scanner scc = new Scanner(System.in);
        for(int i=0 ; i <=  subjectNames.length-1; i++){
           System.out.print("Input name of subject("+(i+1)+") : ");
           subjectNames[i] = scc.next();
       }
       for(int i=0 ; i <= studentNames.length-1 ; i++){
         System.out.print("Input student name: ");
         studentNames[i]= scc.next();
         for(int j=0; j <= subjectNames.length-1; j++){
             System.out.print("Input "+ subjectNames[j] +" marks:");
             marks[i][j] = scc.nextInt();
         }
         System.out.println(); }
    };
    //2
    public static void calculateTotalsAndAverages(int [][]marks,int totalMarks[],int averageMarks[] ){
         
        for(int i=0 ; i <= marks.length-1; i++) {
            int sum = 0;
            for(int j=0 ; j <= marks[i].length-1; j++)
                sum += marks[i][j];
        totalMarks[i] = sum ; 
        averageMarks[i] = sum / marks[i].length;
        }
    };
    
    
    public static void printer(String []studentNames, int []totalMarks, int []averageMarks){
        for(int i=0 ; i <= studentNames.length-1 ; i++ )
                        System.out.print("Name:"+ studentNames[i] +" Total marks: "+ totalMarks[i] +" Average: "+ averageMarks[i]+"\n");
        }
    //3
    public static void assignGrades(int averageMarks[], String grades[],String []studentNames){
        
        for(int i=0 ; i <= averageMarks.length-1; i++){
            if(averageMarks[i] >= 90) grades[i] = "A";
            else if(averageMarks[i] >= 80) grades[i] = "B";
            else if(averageMarks[i] >= 70) grades[i] = "C";
            else if(averageMarks[i] >= 60) grades[i] = "D";
            else grades[i] = "F";
            
            
        }
        for(int i=0; i <= studentNames.length-1; i++)
        System.out.println("Name: "+studentNames[i]+" average: "+averageMarks[i]+" grads: "+grades[i]);
    };
    //4
    public static void displayReport(String studentNames[],int [][]marks,int totalMarks[], int averageMarks[],String grades[],String subjecNames[]){
        
        for(int i=0 ;  i <= studentNames.length - 1 ;i++){
            System.out.print("Name:"+studentNames[i]+" ");
            for(int j=0; j <=  marks[i].length - 1;j++)
                System.out.print( subjecNames[j]+": "+marks[i][j]+" ");
        System.out.println(" Total: "+totalMarks[i]+" Average: "+ averageMarks[i]+" Grades: "+ grades[i]);
        }
    }
    //5
    public static void findTopper(String []studentNames,int []totalMarks){
        int maxIndex = 0;
        for(int i=1; i <= studentNames.length - 1; i++)
            if(totalMarks[i] > totalMarks[maxIndex])
                maxIndex = i;
        System.out.println("The student with higth total marks is : "+ studentNames[maxIndex]);
    }
    //6
    public static void subjectAverages(int [][]marks, String subjectNames[]){
        for(int j=0 ; j <= subjectNames.length - 1; j++){
            int sum = 0;
            for(int i=0 ; i <= marks.length - 1; i++)
                sum = sum + marks[i][j];
            int avg =  sum / marks.length;
            System.out.println( subjectNames[j]+" average: "+ avg);}
    }
    //7
    public static void  sortByRank(String studentNames[], int totalMarks[], int averageMarks[], String grades[], int marks[][]){
        for(int i=0 ; i <= studentNames.length - 2 ; i++)
            for(int j=0 ; j+1 <= studentNames.length - 1; j++)
                if(totalMarks[j] > totalMarks[i]){
                    String sName = studentNames[i];
                    studentNames[i] = studentNames[j];
                    studentNames[j] = sName ;
                    
                    int sTotal = totalMarks[i];
                    totalMarks[i] = totalMarks[j];
                    totalMarks[j] = sTotal ;
                    
                    int sAvg = averageMarks[i];
                    averageMarks[i] = averageMarks[j];
                    averageMarks[j] = sAvg;
                    
                    String sGrads = grades[i];
                    grades[i] = grades[j];
                    grades[j] = sGrads;
                    
                    int sMarks[] =  marks[i];
                    marks[i] = marks[j];
                    marks[j] = sMarks;
        
                }
    }
    
    public static void main(String[]args){
        Scanner sc =new Scanner(System.in);
        int numStudents=0 ; int numSubjects = 0; 
        
        String studentNames[] = new String[numStudents];
        String subjectNames[] = new String[numSubjects];
        int totalMarks[] = new int[numStudents];
        int averageMarks[]  = new int[numStudents];
        String grades[] = new String[numStudents];
        int marks[][]= new int[numStudents][numSubjects];
         
        
    All:while(true){
        System.out.print("===== Student Performance Management Menu =====\n1. Input Data\n2. Calculate Totals and Averages\n3. Assign Grades\n4. Display Report\n5. Find Topper\n6. Subject-wise Averages\n7. Sort by Rank\n8. Exit\nEnter your choice:");
        int B_case = sc.nextInt();
        switch(B_case){
            case 1:
                System.out.print("Input numebr of subjects :");
                numSubjects = sc.nextInt();
                subjectNames = new String[numSubjects];
                        
                System.out.print("Input number of students :");
                numStudents = sc.nextInt();
                studentNames = new String[numStudents];
                
                averageMarks  = new int[numStudents];
                totalMarks = new int[numStudents];
                marks = new int[numStudents][numSubjects];
                
                inputMarks(subjectNames,studentNames,marks);
                    break;
            case 2 :
                 calculateTotalsAndAverages( marks, totalMarks, averageMarks );
                 printer(studentNames,totalMarks,averageMarks);
                 break;
                 
            case 3 :
                grades = new String[numStudents];
                assignGrades( averageMarks ,grades,studentNames);
                break;
            case 4:
                 displayReport(studentNames, marks, totalMarks, averageMarks, grades,subjectNames );
                 break;
            case 5 :
                findTopper(studentNames,totalMarks);
                break;
            case 6 :
                subjectAverages( marks, subjectNames);
                break;
            case 7 :
                sortByRank( studentNames, totalMarks, averageMarks, grades, marks);
                break;
            case 8 :
                break All;
            default:
                System.out.print("invalt input");
         
            
        }

    }
        
        
    }
    
}
