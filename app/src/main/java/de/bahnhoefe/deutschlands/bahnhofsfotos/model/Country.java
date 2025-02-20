package de.bahnhoefe.deutschlands.bahnhofsfotos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Country implements Serializable {
    private String name;
    private String code;
    private String email;
    private String twitterTags;
    private String timetableUrlTemplate;
    private List<ProviderApp> providerApps = new ArrayList<>();

    public Country() {

    }

    public Country(String name, String code, String email, String twitterTags, String timetableUrlTemplate) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.twitterTags = twitterTags;
        this.timetableUrlTemplate = timetableUrlTemplate;
    }

    public static Country getCountryByCode(Set<Country> countries, String countryCode) {
        for (Country country : countries) {
            if (country.getCode().equals(countryCode)) {
                return country;
            }
        }
        return countries.iterator().next(); // get first country as fallback
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitterTags() {
        return twitterTags;
    }

    public void setTwitterTags(String twitterTags) {
        this.twitterTags = twitterTags;
    }

    public String getTimetableUrlTemplate() {
        return timetableUrlTemplate;
    }

    public boolean hasTimetableUrlTemplate() {
        return timetableUrlTemplate != null && !timetableUrlTemplate.isEmpty();
    }

    public void setTimetableUrlTemplate(String timetableUrlTemplate) {
        this.timetableUrlTemplate = timetableUrlTemplate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Country country = (Country) o;
        return code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return name;
    }

    public List<ProviderApp> getProviderApps() {
        return providerApps;
    }

    public void setProviderApps(List<ProviderApp> providerApps) {
        this.providerApps = providerApps;
    }

    public boolean hasCompatibleProviderApps() {
        return ProviderApp.hasCompatibleProviderApps(providerApps);
    }

    public List<ProviderApp> getCompatibleProviderApps() {
        return ProviderApp.getCompatibleProviderApps(providerApps);
    }
}
