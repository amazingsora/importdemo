package Demo.until;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Test {

	public static void main(String[] args) {
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\demo\\users.csv"));) {
			BufferedReader reader = new BufferedReader(isr);
			String line = null;
			while ((line = reader.readLine()) != null) {
				String item[] = line.split(",");
				String data1 = item[0].trim();
				String data2 = item[1].trim();
				String data3 = item[2].trim();
				Connection con = JdbcUntil.getCon();
				PreparedStatement ps = con.prepareStatement("INSERT INTO \"user\" (\"SERNO\", \"NAME\",\"DATE\")" + "VALUES (?,?,?);");
				ps.setObject(1, data1);
				ps.setObject(2, data2);
				ps.setObject(3, data3);
				ps.execute();
				System.out.println("完成"+data1+"筆 ::"+data2);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
