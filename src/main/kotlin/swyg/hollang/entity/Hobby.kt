package swyg.hollang.entity

import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import swyg.hollang.entity.common.BaseTimeEntity

@Entity
@DynamicInsert  //DML 작동시 null값이 아닌 값만 작동함
class Hobby (

    @ManyToMany(fetch = LAZY)
    @JoinTable(
        name = "hobby_category",
        joinColumns = [JoinColumn(name = "hobby_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: MutableList<Category>,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "img_url", nullable = false)
    var imgUrl: String,

) : BaseTimeEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    var id: Long? = null

    @OneToMany(mappedBy = "hobby", cascade = [CascadeType.ALL])
    var hobbyAndTypes: MutableList<HobbyAndType> = mutableListOf()

    @Column(name = "recommend_count")
    @ColumnDefault(value = 0.toString())
    var recommendCount: Long? = null
}