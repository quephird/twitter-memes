(ns twitter-memes.throw-off-roof
  (:gen-class))

(def from-chars "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz")
(def to-chars "∀ᗺƆᗡƎℲ⅁HIſʞ˥WNOԀQᖈS⟘∩ΛMX⅄Zɐqɔpǝɟƃɥᴉɾʞlɯuodbɹsʇnʌʍxʎz")
(def char-mappings 
  (into {} (map vector from-chars to-chars)))

(defn flip-char [char]
  (get-in char-mappings [char] char))

(defn flip-object [object]
  (->> object
    (map flip-char)
    reverse
    (apply str)))

(def template
  (clojure.string/join "\n" 
    ["　　(╯°□°）╯︵"
     "┳┳┳┳┳┳　　|"
     "┓┏┓┏┓┃　　|"
     "┛┗┛┗┛┃　　|"
     "┓┏┓┏┓┃"
     "┛┗┛┗┛┃ %s"
     "┓┏┓┏┓┃"
     "┛┗┛┗┛┃"
     "┓┏┓┏┓┃"
     "┛┗┛┗┛┃"
     "┓┏┓┏┓┃"
     "┃┃┃┃┃┃"
     "┻┻┻┻┻┻"]))

(defn throw-object-text [object]
  (format template (flip-object object)))
