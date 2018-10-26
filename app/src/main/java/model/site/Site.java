package model.site;

public enum Site {
    BC2A("BC2A"),
    BC2B("BC2B"),
    MW2A("MW2A"),
    MW2B("MW2B"),
    MW2E("MW2E");

    private String site;

    Site(String site) {
        this.site =site;
    }

    public String getSite() {
        return site;
    }
}
