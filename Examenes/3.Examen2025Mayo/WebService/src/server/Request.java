package server;

// Objeto que guarda los datos enviados en la petición
public class Request {

    private String pageURL;
    private String user;
    private String clientIP;

    public Request(String pageURL, String user, String clientIP) {
        this.pageURL = pageURL;
        this.user = user;
        this.clientIP = clientIP;
    }

    public String getPageURL() {
        return pageURL;
    }

    public String getUser() {
        return user;
    }

    public String getClientIP() {
        return clientIP;
    }

    @Override
    public String toString() {
        return "Request [clientIP=" + clientIP + ", pageURL=" + pageURL + ", user=" + user + "]";
    }

}
