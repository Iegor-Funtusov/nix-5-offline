package ua.com.alevel.persistence.listener;

import org.apache.commons.lang.StringUtils;
import ua.com.alevel.persistence.entity.User;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class FullNameGenerationListener {

    @PostUpdate
    @PostPersist
    @PostLoad
    public void generateFullName(User user) {
        if (StringUtils.isNotBlank(user.getFirstName()) && StringUtils.isNotBlank(user.getLastName())) {
            user.setFullName(user.getFirstName() + " " + user.getLastName());
        }
    }
}
