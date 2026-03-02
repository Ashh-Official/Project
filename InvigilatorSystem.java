import java.util.ArrayList;
import java.util.List;

class Teacher {
    String name;
    String department;

    public Teacher(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

class ExamRoom {
    String roomName;
    String examSubject;
    Teacher assignedTeacher;

    public ExamRoom(String roomName, String examSubject) {
        this.roomName = roomName;
        this.examSubject = examSubject;
    }
}

public class InvigilatorSystem {

    public static void main(String[] args) {

        // Create teacher list
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Daw Aye Aye", "English"));
        teachers.add(new Teacher("U Kyaw Kyaw", "Math"));
        teachers.add(new Teacher("Daw Su Su", "Physics"));
        teachers.add(new Teacher("U Hla Hla", "Chemistry"));

        // Create exam room list
        List<ExamRoom> rooms = new ArrayList<>();
        rooms.add(new ExamRoom("Room 101", "English"));
        rooms.add(new ExamRoom("Room 102", "Math"));
        rooms.add(new ExamRoom("Room 103", "Physics"));
        rooms.add(new ExamRoom("Room 104", "Chemistry"));

        // Assign teachers
        int teacherIndex = 0;

        for (ExamRoom room : rooms) {
            boolean assigned = false;

            while (!assigned && teacherIndex < teachers.size()) {
                Teacher teacher = teachers.get(teacherIndex);

                // Check teacher is NOT from same department
                if (!teacher.department.equalsIgnoreCase(room.examSubject)) {
                    room.assignedTeacher = teacher;
                    assigned = true;
                }

                teacherIndex = (teacherIndex + 1) % teachers.size();
            }
        }

        // Display result
        System.out.println("Invigilator Assignment Result:");
        for (ExamRoom room : rooms) {
            if (room.assignedTeacher != null) {
                System.out.println(room.roomName + " (" + room.examSubject + " Exam) -> "
                        + room.assignedTeacher.name + " ("
                        + room.assignedTeacher.department + " Department)");
            } else {
                System.out.println(room.roomName + " -> No teacher assigned");
            }
        }
    }
}