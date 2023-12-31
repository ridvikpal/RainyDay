package org.rainyday;

public class AlertSubClass {
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

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
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
