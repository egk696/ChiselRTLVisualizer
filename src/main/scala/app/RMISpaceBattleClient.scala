package app

import java.awt._
import java.awt.image._
import java.rmi._
import java.rmi.server._

import javax.swing._

trait SpaceBattleClient extends Remote {
  @throws(classOf[RemoteException]) def gameStart(count: Int):Unit
  @throws(classOf[RemoteException]) def gameEnd(count: Int):Unit
  @throws(classOf[RemoteException]) def stepTaken(count: Int):Unit
}

object RMISpaceBattleClient extends UnicastRemoteObject with SpaceBattleClient {
  var img:BufferedImage = null

  def main(args: Array[String]): Unit = {
    val panel = new JPanel {
      override def paint(g:Graphics) {
        g.drawImage(img, 0,0, null)
      }
    }
    panel.setSize(new Dimension(500, 500))
    val frame = new JFrame("N-body Space Battle")
    frame.getContentPane.add(panel, BorderLayout.CENTER)
    frame.setLocationRelativeTo(null)
    frame.setSize(new Dimension(500, 500))
    frame.setVisible(true)

    val server = Naming.lookup("rmi://localhost/SpaceBattle")
  }

  @throws(classOf[RemoteException]) def gameStart(count: Int): Unit = {
    //TODO
  }

  @throws(classOf[RemoteException]) def gameEnd(count: Int): Unit = {
    //TODO
  }

  @throws(classOf[RemoteException]) def stepTaken(count: Int): Unit = {
    //TODO
  }
}
