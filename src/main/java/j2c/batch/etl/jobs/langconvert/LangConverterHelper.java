package j2c.batch.etl.jobs.langconvert;

/*
 * Extract Question / Answer
 * Convert to different languages based on params passed
 * Store the convert text in db with the lang
 */
public class LangConverterHelper {

    private String langFrom;
    private String langTo;

    public LangConverterHelper(String langFrom, String langTo) {
        this.langFrom = langFrom;
        this.langTo = langTo;
    }

    public void extract() {

    }

    public void transform() {

    }

    public void load() {

    }

}
