package derilinx.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncidentDAO {
	private Connection connection;
	private Statement statement;

	public List<Incident> getIncidents(PreparedStatement ps) throws SQLException {
		ResultSet rs = null;
		List<Incident> incidents = new ArrayList<Incident>();

		try {
			connection = (Connection) ConnectionFactory.getConnection();
			statement = connection.createStatement();
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Incident incident = new Incident();
				incident.setId(rs.getInt("id"));
				incident.setDistrict(rs.getString("district"));
				incident.setDate(rs.getString("date"));
				incident.setPostcode(rs.getString("postcode"));
				
				incidents.add(incident);
			}
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return incidents;
	}

	public List<Incident> getIncidentById(int id) throws SQLException {
		List<Incident> incidents = null;

		try {
			String incidentQuery = "SELECT * FROM incidents WHERE id = ?;";
			connection = (Connection) ConnectionFactory.getConnection();

			PreparedStatement preparedQuery = connection.prepareStatement(incidentQuery);
			preparedQuery.setInt(1, id);

			incidents = getIncidents(preparedQuery);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return incidents;
	}

	public List<Incident> getIncidentsByDate(String date) throws SQLException {
		List<Incident> incidents = null;

		try {
			connection = (Connection) ConnectionFactory.getConnection();
			String incidentQuery = "SELECT * FROM incidents WHERE date=?";
			PreparedStatement preparedQuery = connection.prepareStatement(incidentQuery);
			preparedQuery.setString(1, date);

			incidents = getIncidents(preparedQuery);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return incidents;
	}

	public List<Incident> getIncidentsByDistrict(String district) throws SQLException {
		List<Incident> incidents = null;

		try {
			connection = (Connection) ConnectionFactory.getConnection();
			String incidentQuery = "SELECT * FROM incidents WHERE district=?";
			PreparedStatement preparedQuery = connection.prepareStatement(incidentQuery);
			preparedQuery.setString(1, district);

			incidents = getIncidents(preparedQuery);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return incidents;
	}

	public List<Incident> getIncidentsByPostcode(String postcode) throws SQLException {
		List<Incident> incidents = null;

		try {
			connection = (Connection) ConnectionFactory.getConnection();
			String incidentQuery = "SELECT * FROM incidents WHERE postcode=?";
			PreparedStatement preparedQuery = connection.prepareStatement(incidentQuery);
			preparedQuery.setString(1, postcode);

			incidents = getIncidents(preparedQuery);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return incidents;
	}
}