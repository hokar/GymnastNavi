package jp.hokari.shunsuke.gymnasticsnavi.model

/**
 * 技のデータクラス
 *
 * Created by shunsuke on 16/04/03.
 */
data class SkillData (
        val id : Long,
        val skillName : String,
        val difficulty : String,
        val classType : Int,
        val genreType : Int,
        val eventType : Int)
