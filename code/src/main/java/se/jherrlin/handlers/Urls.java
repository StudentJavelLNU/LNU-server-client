package se.jherrlin.handlers;


import java.util.regex.Pattern;

import se.jherrlin.model.Request;
import se.jherrlin.tcp.TCPServer;


public class Urls {

    // When urls get a request we pass the request through all the checks.
    // If there is a match, we send the request to the corresponding view.

    public static void urls(Request request){

        // Index view
        if (Pattern.matches("^/$", request.getUri())){
            Views.index(request);
        }

        // Static files
        else if (Pattern.matches("^/static(.+?|$)$", request.getUri())){
            Views.staticfiles(request);
        }

        // Create new blog post form
        else if (Pattern.matches("^/form(.+?|$)$", request.getUri())){
            Views.staticfiles(request);
        }

        // Subpage
        else if (Pattern.matches("^/mysite(.+?|$)$", request.getUri())){
            Views.staticfiles(request);
        }

        // Login endpoint
        else if (Pattern.matches("^/login(.+?|$)$", request.getUri())) {
            Views.login(request);
        }

        // Logout endpoint
        else if (Pattern.matches("^/logout(.+?|$)$", request.getUri())) {
            Views.logout(request);
        }

        // Post new blog endpoint, needs permissions
        else if (Pattern.matches("^/post(.+?|$)$", request.getUri())) {
            if (TCPServer.sessions.contains(request.headerDataMap.get("Cookie")))
                Views.post(request);

            Views.permissionDenied(request);
        }

        // Update blog post, needs permissions
        else if (Pattern.matches("^/put(.+?|$)$", request.getUri())) {
            if (TCPServer.sessions.contains(request.headerDataMap.get("Cookie")))
                Views.put(request);

            Views.permissionDenied(request);
        }

        // All blog posts
        else if (Pattern.matches("^/blog$", request.getUri())) {
            Views.getAllBlogPosts(request);
        }

        // Update blog posts
        else if (Pattern.matches("^/blog/edit(.+?|$)$", request.getUri())) {
            Views.updateAllBlogPosts(request);
        }

        // If we cant match url
        else {Views.notfound(request);}
    }
}
