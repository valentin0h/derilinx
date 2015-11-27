package derilinx.api;

import static spark.Spark.get;

import java.util.List;

import derilinx.db.Incident;
import derilinx.db.IncidentDAO;

public class Handler {

	static IncidentDAO incDao = new IncidentDAO();

	public static void main(String[] args) {

		// handle id calls
		get("/incidents/{:id}", (request, response) -> {
			int id = Integer.parseInt(request.params("id"));
			List<Incident> incidents = incDao.getIncidentById(id);

			return incidents;
		} , new JsonTransformer());

		// handle date calls
		get("/incidents/date/:date", (request, response) -> {
			String date = request.params("date");
			List<Incident> incidents = incDao.getIncidentsByDate(date);

			return incidents;
		} , new JsonTransformer());
		
		// handle district calls
		get("/incidents/district/{:district}", (request, response) -> {
			String district = request.params("district");
			List<Incident> incidents = incDao.getIncidentsByDistrict(district);

			return incidents;
		} , new JsonTransformer());

		// handle postcode calls
		get("/incidents/postcode/:postcode", (request, response) -> {
			String postcode = request.params("postcode");
			List<Incident> incidents = incDao.getIncidentsByPostcode(postcode);

			return incidents;
		} , new JsonTransformer());
	}
}