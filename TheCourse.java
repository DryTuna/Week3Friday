/*
 * There are 34 keywords.
 * package import class if for public private void int double new
 */
// package import class if for public private void int double new
package monday;

public class TheCourse {
	public static void main(String[] args) {
}

class CourseNew {
	private String name;
	private String[] students = new String[2];
	private int numberOfStudents;

	public CourseNew(String name) {
		setName(name);
	}

	public void addStudent(String student) {
		if (numberOfStudents == students.length) {
			increaseSize();
		}

		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	public String[] getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void dropStudent(String student) {
		for (int i = 0; i < numberOfStudents; i++) {
			if (students[i].equals(student)) {
				// Move students[i + 1] to students[i], etc.
				for (int k = i + 1; k < numberOfStudents; k++) {
					students[k - 1] = students[k];
				}

				numberOfStudents--;
				break;
			}
		}
	}
}
