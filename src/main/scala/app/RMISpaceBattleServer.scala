package app

import java.rmi.server.UnicastRemoteObject
import java.rmi.{Remote, RemoteException}

trait SpaceBattleServer extends Remote{
  @throws(classOf[RemoteException]) def connect(client: SpaceBattleClient) : Int
  @throws(classOf[RemoteException]) def shoot(client: SpaceBattleClient) : Unit
  @throws(classOf[RemoteException]) def disconnect(client: SpaceBattleClient) : Int
}

object RMISpaceBattleServer extends UnicastRemoteObject with SpaceBattleServer {
  def main(args: Array[String]): Unit ={

  }

  @throws(classOf[RemoteException]) def connect(client: SpaceBattleClient): Int = {
    //TODO
    0
  }

  @throws(classOf[RemoteException]) def shoot(client: SpaceBattleClient): Unit = {
    //TODO
  }

  @throws(classOf[RemoteException]) def disconnect(client: SpaceBattleClient): Int = {
    //TODO
    0
  }
}