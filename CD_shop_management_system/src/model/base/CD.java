/**
 * Main base class of a simple CD with all its elements
 *
 */
package model.base;

public class CD {
    private String name;
    private String songNumbers;
    private int id;
    private String genre, producerName;

    public CD(String name, String songNumbers, String genre, String producerName) {
        this.genre = genre;
        this.name = name;
        this.songNumbers = songNumbers;
        this.producerName = producerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongNumbers() {
        return songNumbers;
    }

    public void setSongNumbers(String songNumbers) {
        this.songNumbers = songNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @Override
    public String toString() {
        return "CD{" +
                "name='" + name + '\t' +
                ", songNumbers='" + songNumbers + '\t' +
                ", id=" + id +
                ", genre='" + genre + '\t' +
                ", producerName='" + producerName + '\t' +
                '}' + "\n";
    }
}
