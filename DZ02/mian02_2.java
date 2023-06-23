package DZ02;

public class mian02_2 {

    public static void main(String[] args) {
        String s = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        StringBuilder sb = new StringBuilder();
        String[] se = s.split("\\},\\{");
        for (String entry : se) {
            String[] f = entry.split(",");
            String n = f[0].split(":")[1].replaceAll("\"", "");
            String g = f[1].split(":")[1].replaceAll("\"", "");
            String j = f[2].split(":")[1].replaceAll("\"", "").replaceAll("\\}", "").replaceAll("\\]", "");
            sb.append("Студент ").append(n).append(" получил ").append(g).append(" по предмету ").append(j).append(".\n");
        }
        System.out.println(sb.toString());
    }
}