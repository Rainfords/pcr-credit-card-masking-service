package com.rainfordsdigital.examples;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {

      String p = "49991234";
      String c = "1111";
      String r = "2222";

      List<String> base = Arrays.asList(p, c, r);

      String cc = "4999123411112222";
      String mask = "xxxxxx";

      PermutationIterable<String> permutationIterable2 =
          new PermutationIterable<>(base, new RecursiveCounter<>(base.size()));
int n=0;
      for (List<String> permutation : permutationIterable2) {
        String candidate = joinParts(permutation);
        System.out.println("Candidate: " + candidate + " " + n++);
        // CC found!
        if (candidate.equals(cc)) {
          System.out.println("CC Found:");
          String masked = StringUtils.overlay(candidate, mask, 6, 12);
          System.out.println(masked);
          System.out.println("p = " +masked.substring(candidate.indexOf(p) , candidate.indexOf(p) + p.length()));
          System.out.println("c = " +masked.substring(candidate.indexOf(c) , candidate.indexOf(c) + c.length()));
          System.out.println("r = " +masked.substring(candidate.indexOf(r) , candidate.indexOf(r) + r.length()));
          break;
        }

      }



    }

    private static String joinParts(List<String> parts) {
      StringBuilder sb = new StringBuilder();
      for (String part : parts) {
        sb.append(part);
      }
      return sb.toString();
    }
}
