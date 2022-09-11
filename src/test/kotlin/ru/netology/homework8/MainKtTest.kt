package ru.netology.homework8

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainKtTest {

    @Test
    fun addNote() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
    }

    @Test(expected = NoNoteListException::class)
    fun addCommentNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(4, 23, Comment(2, "С 13го по 14ое"))

    }

    @Test(expected = NoNoteException::class)
    fun addCommentNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 23, Comment(2, "С 13го по 14ое"))

    }

    @Test
    fun addComment() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))

    }

    @Test(expected = NoNoteListException::class)
    fun deleteNoteNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.deleteNote(4, 12)

    }

    @Test
    fun deleteNote() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.deleteNote(1, 12)
    }

    @Test(expected = NoNoteListException::class)
    fun deleteCommentNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(4, 12, 2)
    }

    @Test(expected = NoNoteException::class)
    fun deleteCommentNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 23, 2)
    }

    @Test(expected = NoCommentException::class)
    fun deleteCommentNoCommentException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 12, 1)
    }

    @Test
    fun deleteComment() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 12, 2)
    }


    @Test(expected = NoNoteListException::class)
    fun editNoteNoNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.editNote(5, 12, "Место", "Где собираемся?")
    }

    @Test(expected = NoNoteException::class)
    fun editNoteNoNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.editNote(1, 23, "Место", "Где собираемся?")
    }

    @Test
    fun editNote() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.editNote(1, 12, "Место", "Где собираемся?")

    }

    @Test(expected = NoNoteListException::class)
    fun editCommentNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.editComment(4, 12, 2, "14го числа")
    }

    @Test(expected = NoNoteException::class)
    fun editCommentNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.editComment(1, 23, 2, "14го числа")
    }

    @Test(expected = NoCommentException::class)
    fun editCommentNoCommentException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.editComment(1, 12, 1, "14го числа")
    }

    @Test
    fun editComment() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.editComment(1, 12, 2, "14го числа")
    }

    @Test(expected = NoNoteListException::class)
    fun getNoteNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
        NoteService.getNote(2, "14, 15")
    }

    @Test(expected = NoNoteException::class)
    fun getNoteNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
        NoteService.getNote(1, "14, 15")
    }

    @Test
    fun getNote() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
        NoteService.getNote(1, "12, 13")
    }

    @Test(expected = NoNoteListException::class)
    fun getNoteIDNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
        NoteService.getNoteID(2, 12)
    }

    @Test
    fun getNoteID() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
        NoteService.getNoteID(1, 12)
    }

    @Test
    fun getNoteIDFalse() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addNote(1, Note(noteId = 13, "Развлечения", "Бар"))
        NoteService.getNoteID(1, 14)

    }

    @Test(expected = NoNoteListException::class)
    fun getCommentsNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.getComments(4, 12, 1)
    }

    @Test(expected = NoNoteException::class)
    fun getCommentsNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.getComments(1, 23, 1)
    }

    @Test
    fun getComments() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.getComments(1, 12, 1)
    }

    @Test(expected = NoNoteListException::class)
    fun restoreCommentNoteListException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 12, 2)
        NoteService.restoreComment(4, 12, 2)
    }

    @Test(expected = NoNoteException::class)
    fun restoreCommentNoteException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 12, 2)
        NoteService.restoreComment(1, 23, 2)
    }

    @Test(expected = NoCommentException::class)
    fun restoreCommentNoCommentException() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 12, 2)
        NoteService.restoreComment(1, 12, 1)
    }

    @Test
    fun restoreComment() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.addComment(1, 12, Comment(2, "С 13го по 14ое"))
        NoteService.deleteComment(1, 12, 2)
        NoteService.restoreComment(1, 12, 2)
    }

    @Test
    fun printNoteLists() {
        NoteService.addNote(1, Note(noteId = 12, "Отдых", "Привет"))
        NoteService.printNoteLists()
    }
}