(ns twitter-memes.bunny-sign
  (require [clojure.string :as s])
  (:gen-class))



; |￣￣￣￣￣￣| 
; | insert      |
; | foolishness | 
; | here        |     
; | ＿＿＿＿＿＿| 

(def template
  ["(\\__/) ||" 
   "(•ㅅ•) ||"
   "/ 　 づ"])

(defn pad-word [word max-length]
  (let [length (count word)
        spaces (inc (Math/ceil (* 0.5 (- max-length length))))
        pad    (apply str (repeat spaces " "))]
    (str "|" pad word pad "|")))

(defn bunnysign-text [text]
  (let [words      (s/split text #" ")
        max-length (apply max (map count words))
        sign-width (Math/floor (* 0.7 max-length))
        top        [(apply str (concat [\|] (repeat sign-width \￣) [\|]))]
        bottom     [(apply str (concat [\|] (repeat sign-width \＿) [\|]))]
        body       (map #(pad-word % max-length) words)
        ]
    (s/join "\n" (concat top body bottom template))))
