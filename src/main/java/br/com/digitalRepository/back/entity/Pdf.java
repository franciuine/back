package br.com.digitalRepository.back.entity;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import br.com.digitalRepository.back.entity.enums.RoleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "pdf_file")
public class Pdf 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Size(max = 300000)

    private String filepdf;
    
   // @OneToOne(mappedBy = "pdf")
   // private LessonPlan lessonPlan;
   //
   // public LessonPlan getLessonPlan(){
   //     return this.lessonPlan;
   // }
   //
   // public void setLessonPlan(LessonPlan lessonPlan){
   //     this.lessonPlan = lessonPlan;
   // }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFile()
    {
        return this.filepdf;
    }

    public void setFile(String file)
    {
        this.filepdf = file;
    }
}
