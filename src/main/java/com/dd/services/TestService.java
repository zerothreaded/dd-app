package com.dd.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.dd.model.ErrorMessage;
import com.dd.model.Link;
import com.dd.model.Resource;
import com.dd.model.Test;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
public class TestService {

	@GET
	@Timed
	public Response getAll() {
		try {
			Test test1 = new Test();
			test1.setId("test_id_1");
			test1.addLink(Resource.KEY_LINK_SELF, new Link("/tests/" + test1.getId(), "self"));
			
			Test test2 = new Test();
			test2.setId("test_id_2");
			test2.addLink(Resource.KEY_LINK_SELF, new Link("/tests/" + test2.getId(), "self"));
			
			List<Test> testList = new ArrayList<Test>();
			testList.add(test1);
			testList.add(test2);
			return Response.status(200).entity(testList).build();
		} catch(Exception e) {
			e.printStackTrace();
			return Response.status(300).entity(new ErrorMessage("failed", e.getMessage())).build();			
		}
	}

	@GET
	@Timed
	@Path("/{testId}")
	public Response get(@PathParam("testId") String testId) {
		try {
			Test test = new Test();
			test.setId(testId);
			test.addLink(Resource.KEY_LINK_SELF,  new Link("/tests/" + test.getId(), "self"));
			return Response.status(200).entity(test).build();
		} catch(Exception e) {
			e.printStackTrace();
			return Response.status(300).entity(new ErrorMessage("failed", e.getMessage())).build();			
		}
	}
	
}
