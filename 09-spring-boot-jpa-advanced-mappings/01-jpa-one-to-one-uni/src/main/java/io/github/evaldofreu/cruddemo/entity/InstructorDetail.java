package io.github.evaldofreu.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="youtube_channel")
    String youtubeChannel;

    @Column(name="hobby")
    String hobby;

    // @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL) // para todas as operacoes
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) // para todas as operacoes menos de remoção
    private Instructor instructor;

    public InstructorDetail() {}
    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
