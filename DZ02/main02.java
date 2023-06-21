package DZ02;

import org.json.simple.JSONObject;
public class main02 {
      public static void main(String[] args) {

        String filters = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":null}";
        JSONObject filterData = new JSONObject(filters);
        StringBuilder whereClause = new StringBuilder("select * from students where ");

        if (!filterData.isNull("name")) {
            whereClause.append("name = '").append(filterData.getString("name")).append("' AND ");
        }
        if (!filterData.isNull("country")) {
            whereClause.append("country = '").append(filterData.getString("country")).append("' AND ");
        }
        if (!filterData.isNull("city")) {
            whereClause.append("city = '").append(filterData.getString("city")).append("' AND ");
        }
        if (!filterData.isNull("age")) {
            whereClause.append("age = ").append(filterData.getInt("age")).append(" AND ");
        }

        // Удаление последнего "AND" из строки
        if (whereClause.toString().endsWith(" AND ")) {
            whereClause.setLength(whereClause.length() - 5);
        }

        System.out.println(whereClause.toString());

    }
}  
