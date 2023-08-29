package sumyitschool.thing_project.model;

import java.util.ArrayList;

public class Thing {
        private boolean isActive;
        private String name;
        private String place;
        private String time;
        private String comments;

        public Thing(boolean isActive, String name, String place, String time, String comments) {
            this.isActive = isActive;
            this.name = name;
            this.place = place;
            this.time = time;
            this.comments = comments;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public boolean getIsActive() {
            return isActive;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String price) {
            this.time = price;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String toString() {
            return isActive + "-" + name + "-" + place + "-" + time + "-" + comments;
        }
}

