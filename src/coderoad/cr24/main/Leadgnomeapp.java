package coderoad.cr24.main;




import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import coderoad.cr24.rest.SeleniumRest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@ApplicationPath("/*")
public class Leadgnomeapp extends Application {

    protected HashSet<Object> singletons = new HashSet<Object>();
    public Leadgnomeapp() {
        singletons.add(new SeleniumRest());
    }

   
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> providers = new LinkedHashSet<Class<?>>();
   
        
        
        providers.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
        providers.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
        providers.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
        providers.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
        return providers;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
