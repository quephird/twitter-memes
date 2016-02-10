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
     "┃┃┃┃┃┃ %s"
     "┻┻┻┻┻┻"]))

 ; TODO: * Splitting of object text across
 ;         multiple lines
 (def possible-targets
   {"fire" "🔥🔥🔥🔥"
    "snakes" "🐍🐍🐍🐍"
    "crocodiles" "🐊🐊🐊🐊"
    "ocean" "🌊🌊🌊🌊"
    "sarlacc" "╲╲\\\\||//╱╱"})
 
(defn throw-object-text [object into]
  (let [target (get-in possible-targets [into] "")]
    (format template (flip-object object) target)))
