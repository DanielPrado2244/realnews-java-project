<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      html {
        display: flex;
        align-items: center;
        justify-content: center;
      }
      body {
        width: 400px;
      }
      .container h1 {
        text-align: center;
      }
      .container .comments ul {
        margin: 0;
        padding: 0;
      }
      .container .comments ul li {
        list-style: none;
        margin-left: 20px;
      }
      .container .comments ul li + li {
        margin-top: 10px;
      }
      .container .comments ul li .comment-group {
        display: flex;
        flex-direction: column;
      }
      .container .comments ul li .comment-group .user {
        font-weight: 500px;
      }
      .container .comments ul li .comment-group .comment {
        margin-left: 20px;
      }
      .container .news-content p {
        max-height: 250px;
        overflow: hidden;
        overflow-y: auto;
      }
      .container .form-group {
        display: flex;
        flex-direction: column;
      }
      .container .form-group label {
        font-weight: 500;
      }
      .container .form-group input {
        padding: 10px;
      }
    </style>
  </head>
  <body>   
    <div class="container">
      <h1>RealNews</h1>
      <hr />
      <section class="news-content">
        <h3>Titulo da noticia</h3>
        <hr />
        <p>
          Lorem Ipsum is simply dummy text of the printing and typesetting
          industry. Lorem Ipsum has been the industry's standard dummy text
          ever since the 1500s, when an unknown printer took a galley of
          type and scrambled it to make a type specimen book. It has
          survived not only five centuries, but also the leap into
          electronic typesetting, remaining essentially unchanged. It was
          popularised in the 1960s with the release of Letraset sheets
          containing Lorem Ipsum passages, and more recently with desktop
          publishing software like Aldus PageMaker including versions of
          Lorem Ipsum.
        </p>
      </section>
      <section class="comments">
        <h3>Comentarios</h3>
        <ul>
            <c:forEach items="${comments}" var="comment">
                <li>
                    <div class="comment-group">
                        <span class="user">${comment.username}</span>
                        <span class="comment">${comment.comment}</span>
                    </div>
                  <hr />
                </li>
            </c:forEach>
        </ul>
      </section>

      <form action="CreateComment.do" method="post">
        <h4>Adicionar comentario</h4>

        <div class="form-group">
          <label>Nome</label>
          <input type="text" id="username" name="username" />
        </div>

        <div class="form-group">
          <label>Comentario</label>
          <textarea id="user-comment" rows="3" name="comment"></textarea>
        </div>
        <button type="submit">Enviar</button> 
      </form>
    </div>
  </body>
</html>
