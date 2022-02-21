package newbies.java16.crmapp.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

import newbies.java16.crmapp.util.UrlConst;
@WebFilter(filterName = "sitemesh", urlPatterns = UrlConst.GLOBAL)
public class SitemeshFilter extends SiteMeshFilter{

}
