package se.jherrlin.model;


public class Request {
    private HTTPMethod method;
    private String uri;
    private String httpversion;
    private String clientAddress;
    private int clientPort;

    public Request() {
    }

    public Request(HTTPMethod method, String uri, String httpversion) {
        this.method = method;
        this.uri = uri;
        this.httpversion = httpversion;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    public void setMethod(HTTPMethod method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHttpversion() {
        return httpversion;
    }

    public void setHttpversion(String httpversion) {
        this.httpversion = httpversion;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method=" + method +
                ", uri='" + uri + '\'' +
                ", httpversion='" + httpversion + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientPort=" + clientPort +
                '}';
    }
}
