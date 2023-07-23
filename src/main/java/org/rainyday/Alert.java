package org.rainyday;

import java.util.ArrayList;

public class Alert {
    private ArrayList<AlertSubClass> alert;
    public static class AlertSubClass{
        private String headline, msgtype, severity, urgency, areas, category, certainty, event, note
                , effective, expires, desc, instruction;

        public String getHeadline() {
            return headline;
        }

        public String getMsgtype() {
            return msgtype;
        }

        public String getSeverity() {
            return severity;
        }

        public String getUrgency() {
            return urgency;
        }

        public String getAreas() {
            return areas;
        }

        public String getCategory() {
            return category;
        }

        public String getCertainty() {
            return certainty;
        }

        public String getEvent() {
            return event;
        }

        public String getNote() {
            return note;
        }

        public String getEffective() {
            return effective;
        }

        public String getExpires() {
            return expires;
        }

        public String getDesc() {
            return desc;
        }

        public String getInstruction() {
            return instruction;
        }

        @Override
        public String toString() {
            return "AlertSubClass{" +
                    "headline='" + headline + '\'' +
                    ", msgtype='" + msgtype + '\'' +
                    ", severity='" + severity + '\'' +
                    ", urgency='" + urgency + '\'' +
                    ", areas='" + areas + '\'' +
                    ", category='" + category + '\'' +
                    ", certainty='" + certainty + '\'' +
                    ", event='" + event + '\'' +
                    ", note='" + note + '\'' +
                    ", effective='" + effective + '\'' +
                    ", expires='" + expires + '\'' +
                    ", desc='" + desc + '\'' +
                    ", instruction='" + instruction + '\'' +
                    '}';
        }
    }

    public ArrayList<AlertSubClass> getAlert() {
        return alert;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alert=" + alert +
                '}';
    }
}
