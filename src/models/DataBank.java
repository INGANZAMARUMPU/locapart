package models;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DataBank {

	public Dao<Ville, String> ville_dao;
	public Dao<Reservation, String> reservation_dao;
	public Dao<Appartement, String> appartement_dao;
    String databaseUrl = "jdbc:sqlite:spectacles.sqlite3";

	public DataBank() {
        try {
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

			ville_dao = DaoManager.createDao(connectionSource, Ville.class);
			reservation_dao = DaoManager.createDao(connectionSource, Reservation.class);
			appartement_dao = DaoManager.createDao(connectionSource, Appartement.class);

			TableUtils.createTableIfNotExists(connectionSource, Ville.class);
			TableUtils.createTableIfNotExists(connectionSource, Reservation.class);
			TableUtils.createTableIfNotExists(connectionSource, Appartement.class);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
//    public static Personne recherchePersonne(String username) {
//    	Personne personne = null;
//    	Where where = Home.connectrice.personneDAO.queryBuilder().where();
//    	try {
//			where.eq("username", username);
//		    personne = (Personne) where.queryForFirst();
//		} catch (SQLException e) {}
//		return personne;
//	}
}