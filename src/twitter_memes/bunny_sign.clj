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

(defn pad-line [line max-length]
  (let [length (count line)
        spaces (inc (Math/ceil (* 0.5 (- max-length length))))
        pad    (apply str (repeat spaces " "))]
    (str "|" pad line pad "|")))

(defn bunnysign-text [text]
  (let [lines      (s/split text #"\|")
        max-length (apply max (map count lines))
        sign-width (Math/floor (* 0.7 max-length))
        top        [(apply str (concat [\|] (repeat sign-width \￣) [\|]))]
        bottom     [(apply str (concat [\|] (repeat sign-width \＿) [\|]))]
        body       (map #(pad-line % max-length) lines)
        ]
    (s/join "\n" (concat top body bottom template))))
