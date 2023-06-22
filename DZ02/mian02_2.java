package DZ02;

public class mian02_2 {

    public static void main(String[] args) {
        String input = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        StringBuilder sb = new StringBuilder();
        String[] entries = input.split("\\},\\{");
        for (String entry : entries) {
            String[] fields = entry.split(",");
            String lastName = fields[0].split(":")[1].replaceAll("\"", "");
            String grade = fields[1].split(":")[1].replaceAll("\"", "");
            String subject = fields[2].split(":")[1].replaceAll("\"", "").replaceAll("\\}", "").replaceAll("\\]", "");
            sb.append("Студент ").append(lastName).append(" получил ").append(grade).append(" по предмету ").append(subject).append(".\n");
        }
        System.out.println(sb.toString());
    }
}