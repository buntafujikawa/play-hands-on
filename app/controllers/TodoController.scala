package controllers

import javax.inject._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import services._

class TodoController @Inject()(todoService: TodoService, mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {
  def helloWorld() = Action { implicit request: MessagesRequest[AnyContent] =>
    /*
    Ok 200
    BadRequest 400
    Forbidden 403
    NotFound 404
    Redirect リダイレクト処理
    */
    Ok("Hello World")
  }

  def list() = Action { implicit request: MessagesRequest[AnyContent] =>
    val items: Seq[Todo] = todoService.list()
    Ok(views.html.list(items))
  }
}
