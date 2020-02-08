package com.example.sih;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragment_one extends Fragment {
    TextView t;
    String crop;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        crop = MainActivity.result;
        if(crop.equals("Cotton")) {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Cotton is the leading plant fiber crop worldwide and is grown commercially in the temperate and tropical regions. \n" +
                    "\n" +
                    "Cotton is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family Malvaceae. The fiber is almost pure cellulose. Under natural conditions, the cotton bolls will increase the dispersal of the seeds.\n" +
                    "\n" +
                    "The product harvested from the cotton field is known as seed cotton, which is separated at a ginning mill into lint and cotton seed. Cotton lint is further processed to make cotton yarn, which is, in turn, used for the manufacturing finest forms of fabrics / cloth, hosiery, apparel, canvas, tarpaulin. \n" +
                    "\n" +
                    " India is the world's largest producer of cotton.  In the United States, cotton is usually measured in bales, which measure approximately 0.48 cubic meters (17 cubic feet) and weigh 226.8 kilograms. \n");
        }
        if(crop.equals("Sugarcane"))//sugercane
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Sugarcane is the leading plant fiber crop worldwide and is grown commercially in the temperate and tropical regions. \n" +
                    "\n" +
                    "Sugarcane is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family Malvaceae. The fiber is almost pure cellulose. Under natural conditions, the cotton bolls will increase the dispersal of the seeds.\n" +
                    "\n" +
                    "The product harvested from the cotton field is known as seed cotton, which is separated at a ginning mill into lint and cotton seed. Cotton lint is further processed to make cotton yarn, which is, in turn, used for the manufacturing finest forms of fabrics / cloth, hosiery, apparel, canvas, tarpaulin. \n" +
                    "\n" +
                    " India is the world's largest producer of cotton.  In the United States, cotton is usually measured in bales, which measure approximately 0.48 cubic meters (17 cubic feet) and weigh 226.8 kilograms. \n");
        }
        if(crop.equals("Rice"))//rice
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Rice is the most important human food crop in the world, directly feeding more people than any other crop. \n" +
                    "\n" +
                    "Rice is the seed of the grass species Oryza sativa (Asian rice) or Oryza glaberrima (African rice). As a cereal grain, it is the most widely consumed staple food for a large part of the world's human population, especially in Asia.\n" +
                    "\n" +
                    "Rice cultivation is well-suited to countries and regions with low labor costs and high rainfall, as it is labor-intensive to cultivate and requires ample water. \n" +
                    "\n" +
                    "The rice plant can grow to 1–1.8 m (3.3–5.9 ft) tall, occasionally more depending on the variety and soil fertility. \n" +
                    "\n");
        }
        /*if(crop.equals("Sugarcane"))//potato
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Potato (Solanum tuberosum) is the most important food crop of the world. \n" +
                    "Potato is a temperate crop grown under subtropical conditions in India. The potato is a crop which has always been the ‘poor man’s friend’. Potato is being cultivated in the country for the last more than 300 years.\n" +
                    "\n" +
                    "Potatoes are used for several industrial purposes such as for the production of starch and alcohol. Potato starch (farina) is used in laundries and for sizing yarn in textile mills. \n" +
                    "\n" +
                    "Potatoes are also used for the production of dextrin and glucose. As a food product itself, potatoes are converted into dried products such as ‘potato chips’, ‘sliced’ or ‘shredded potatoes’.\n" +
                    "\n" +
                    "It is a much branched bushy herb, usually 0.5 to 1m in height possessing underground stems bearing the edible tubers. The leaves are odd pinnate with a large terminal leaflet. It flowers in cymose panicles.\n");
        }*/
        if(crop.equals("Bajra"))//Bajara
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Bajra or pearl millet is an important coarse grain crop and considered to be the poor man’s staple nourishment. It is believed to be the native of Africa, from where it spread to India and other countries. It is one of the important crops of South Eastern Asia, China, India, Pakistan, Arabia, Sudan, Russia and Nigeria. In India, it is grown in Haryana, Gujarat, Maharashtra, Rajasthan and Uttar Pradesh.\n" +
                    "\n" +
                    "Bajra crop survives under adverse climatic conditions.\n" +
                    "\n" +
                    " It is grown everywhere in India The local varieties of bajra grow very tall and mature late.\n" +
                    "\n" +
                    " It is a drought tolerant crop and is suitable for dry farming situations.\n");
        }
        if(crop.equals("Wheat"))//Wheat
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Wheat is the main cereal crop in India. The total area under the crop is about 29.8 million hectares in the country. \n" +
                    "\n" +
                    "The major increase in the productivity of wheat has been observed in the states of Haryana, Punjab and Uttar Pradesh. Higher area coverage is reported from MP in recent years.\n" +
                    "\n" +
                    "Wheat is a grass widely cultivated for its seed, a cereal grain which is a worldwide staple food. The many species of wheat together make up the genus Triticum; the most widely grown is common wheat (T. aestivum).\n" +
                    "\n" +
                    "Wheat is an important source of carbohydrates.\n");
        }
        /*if(crop.equals("Sugarcane"))//Soyabean
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soybeans belong to the legume family and are native to East Asia. It is also known as the “Golden Bean” of the twentieth century.\n" +
                    "\n" +
                    "About 85 percent of the world’s soybeans are processed, or \"\"crushed,\"\" annually into soybean meal and oil.\n" +
                    "\n" +
                    "Approximately six percent of soybeans are used directly as human food as soya chunks, mostly in Asia.\n" +
                    "\n" +
                    "Soy’s another product is called soybean milk or soy milk. Creamy white soy milk resembles cow's milk. Soy milk requires only soybeans and water (and steam) for its creation. When soy milk is curdled, it is known as tofu which is a paneer or cottage cheese like product\n");
        }*/
        if(crop.equals("Watermelon"))//WaterMalon
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Botanically, watermelon is called Citrullus lanatus and it belongs to Cucurbitaceae family. \n" +
                    "\n" +
                    " The melons grow on a vine that can reach a length of 3 meters. It is an annual plant, that is, it can only survive in one growing season. \n" +
                    "\n" +
                    "It is a sweet, edible fruit that has a green rind on the outside and edible red-colored flesh with black-colored seeds on the inside. The color of the flesh varies from pink to red. \n" +
                    "\n" +
                    " There are some varieties of watermelon that have yellow flesh. According to botanists, this cool fruit has its origins in the African deserts about five thousand years ago. \n" +
                    "\n" +
                    "Some of its wild varieties are still found growing here. They found their way up north through Egypt and people began cultivating it during the Roman Era.\n");
        }
        if(crop.equals("Cabbage"))//cabbage
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Cabbage (Brassica oleracea var capitata) is a small, leafy biennial producing a compact globular mass of smooth or crincled leaves wrapped over each other known as head. \n" +
                    "\n" +
                    "The outer leaves are generally larger than the inner. The stem is short and stout. Plants flower generally after winter.\n" +
                    "\n" +
                    "Flavour in cabbage leaves is due to the glycoside sinigrin.  Cabbage contains goitrogens which cause enlargement of thyroid glands.\n" +
                    "\n" +
                    "Cabbage is an excellent source of minerals such as calcium (39 mg), iron (0.8 mg), magnesium (10 mg), sodium (14.1 mg), potassium (114 mg) and phosphorus (44 mg).  \n" +
                    "\n" +
                    "The major cabbage producing states are Uttar Pradesh, Odisha, Bihar, Assam, West Bengal, Maharashtra and Karnataka.\n" +
                    "\n");
        }
        return view;
    }

}
