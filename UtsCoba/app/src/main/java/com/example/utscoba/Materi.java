package com.example.utscoba;

class Materi {

    // Member variables representing the title and information about the materi.
    private String title;

    private String isi;
    private final int imageResource;

    /**
     * Constructor for the Materi data model.
     *
     * @param title The name if the materi.
     *
     */


    public Materi(String title, String isi, int imageResource) {
        this.title = title;

        this.imageResource = imageResource;
        this.isi = isi;

    }

    /**
     * Gets the title of the materi.
     *
     * @return The title of the materi.
     */
    String getTitle() {

        return title;
    }

    /**
     * Gets the info about the materi.
     *
     * @return The info about the materi.
     */


    String getIsi() {

        return isi;
    }

    public int getImageResource() {

        return imageResource;
    }
}
