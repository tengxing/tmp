package online.edu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Describe: 课程类型
 */
public class CourseType extends InitModel implements Serializable {

    private Integer id;
    private String typeName;
    private Date releaseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
