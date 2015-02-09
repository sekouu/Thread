/* Copyright (c) 2015, Frédéric Fauberteau
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Model.BinarySearchTree;
import Model.RunnableTree;
import Test.ThreadTest;

public class Main {
  
  public static final void main(String[] args) throws IOException {

    String name = "rbtree";

    Random rand = new Random();

    BinarySearchTree<Integer> rbtree = new BinarySearchTree<Integer>();

    Thread threads [] = new Thread [100];

    int thread_number = 101;
    while (thread_number > 100){
      System.out.println("How many threads do you want to use (less than 100):");
      Scanner scanner = new Scanner(System.in);
      thread_number = scanner.nextInt();
    }



    int nbObjectAdd = rand.nextInt(100);
    System.out.println("There is " + nbObjectAdd + " object add to the graphe");
    ExecutorService service = Executors.newFixedThreadPool(thread_number);
    service.execute(new RunnableTree(rbtree, nbObjectAdd));
    service.shutdown();
    while (!service.isTerminated()){}


    PrintWriter writer = new PrintWriter(name + ".dot");
    writer.println(rbtree.toDOT(name));
    writer.close();
    ProcessBuilder builder = new ProcessBuilder("/usr/local/bin/dot", "-Tpdf", "-o", name + ".pdf", name + ".dot");
    builder.start();
  }
  
}
