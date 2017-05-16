package online.edu.entity;

import java.io.Serializable;


public class Course extends InitModel implements Serializable{

    private Integer id;
    private String name;
    private String summary;
    private String teachTime;
    private String suitPeople;
    private String feature;
    private CourseType courseType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(String teachTime) {
        this.teachTime = teachTime;
    }

    public String getSuitPeople() {
        return suitPeople;
    }

    public void setSuitPeople(String suitPeople) {
        this.suitPeople = suitPeople;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
