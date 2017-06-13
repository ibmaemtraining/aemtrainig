package com.ibm.aemtrainig.core.servlets;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import javax.servlet.ServletException;
import java.io.IOException;
@SuppressWarnings("serial")
@SlingServlet(
resourceTypes = "sling/servlet/default",
selectors = "hello",
extensions = "html",
methods = "GET")
public class SampleServlet extends SlingSafeMethodsServlet
{
@Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException
    {
	String poojaTitle= (String)request.getResource().getChild("jcr:content").adaptTo(ValueMap.class).get("jcr:title");
    response.getOutputStream().println("Testing "+ poojaTitle);
    }
}