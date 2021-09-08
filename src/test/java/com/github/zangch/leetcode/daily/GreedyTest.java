package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-07
 */
class GreedyTest {
    private final Greedy greedy = new Greedy();
    @Test
    void canJump() {
        System.out.println(greedy.canJump(new int[]{1,2,3,4,0,0,0,1}));
    }
    @Test
    void jump() {
        System.out.println(greedy.jump(new int[]{1,2,3,4,0,0,0,1}));
    }
    @Test
    void maxProfit() {
        System.out.println(greedy.maxProfit(new int[]{1,2,3,4,0,0,0,1}));
    }
    @Test
    void largestNumber() {
        System.out.println(greedy.largestNumber(new int[]{999999991,9}));
    }
    @Test
    void candy() {
        System.out.println(greedy.candy(new int[]{7,9,6,2,4,5}));
    }
    @Test
    void isMatch() {
        System.out.println(greedy.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
    @Test
    void findMaximizedCapital() {
        System.out.println(greedy.findMaximizedCapital(111 , 12,
                        new int[]{319,178,37,756,152,763,481,1055,594,825,759,494,1087,696,717,358,1091,1145,1043,245,779,957,3,1060,1141,926,226,657,869,740,1170,746,889,416,634,209,1189,1076,819,1144,40,807,561,400,283,133,186,839,1043,491,936,559,70,9,854,1172,9,739,871,436,1087,1029,66,561,798,1141,701,1020,1072,92,636,509,392,77,84,202,843,563,329,906,101,997,1162,105,876,460,285,446,753,516,60,932,323,659,9,639,1041,861,1199,343,792,1114,536,405,542,805,929,589,538,410,143,114,24,1064,682,536,1016,1141,843,472,817,196,673,189,915,196,755,203,956,283,833,836,22,899,232,655,572,207,819,639,1024,887,407,385,251,896,165,290,193,357,870,678,411,697,998,344,628,866,1004,894,547,574,36,847,691,601,896,363,21,1133,115,658,855,1042,2,189,230,215,747,971,581,809,832,311,35,639,1127,701,167,672,763,997,1061,1170,289,806,91,198,720,67,273,863,437,152,671,635,968,107,58,453,392,236,875,719,44,850,176,580,937,227,125,851,1188,915,747,1175,69,743,250,275,290,787,780,516,775,279,256,649,83,1180,372,655,813,750,381,807,988,977,430,282,1067,551,726,756,372,17,1016,550,1128,223,174,85,1039,1,27,178,822,243,440,79,772,211,640,454,1141,654,351,54,794,711,157,492,307,1156,937,212,461,417,741,1104,642,1147,833,1194,1066,1070,876,1045,341,854,1014,787,518,404,1068,385,756,998,298,439,917,183,71,363,38,828,372,1071,195,481,1153,871,712,803,849,145,1144,410,420,561,678,241,498,548,436,871,810,180,635,119,665,551,1132,807,408,685,489,274,459,28,987,935,310,284,1163,924,812,267,1123,782,1065,1075,1199,1047,289,280,1044,931,1056,625,672,150,41,1084,998,151,483,226,548,277,1187,1010,262,1048,493,1084,845,1127,1009,773,129,547,798,118,559,463,972,666,1155,519,381,405,819,201,790,729,1100,614,691,3,386,206,514,387,612,1073,158,67,1116,164,496,1056,1159,348,530,28,1177,774,1139,559,563,310,916,897,36,1060,173,952,123,635,911,711,304,611,481,645,532,1033,385,402,797,117,307,969,1147,1127,434,1099,1043,104,74,257,778,934,901,106,84,525,138,698,877,1009,487,450,649,736,802,1032,456,757,10,2,720,1155,234,844,880,1053,1134,821,1094,970,1095,976,101,1163,104,38,198,350,896,345,867,1129,1064,403,228,1103,416,561,722,915,1161,252,45,632,1163,232,174,964,876,1126,479,432,984,815,544,1005,620,497,1021,763,169,1028,706,1112,150,368,483,251,721,492,686,1105,38,1140,1085,153,366,428,296,28,648,873,21,236,393,581,1043,1086,747,402,201,1196,416,788,318,257,815,735,1023,1143,1100,922,1033,884,824,963,159,904,21,1168,511,723,400,239,338,89,1099,572,674,54,891,426,277,91,504,302,616,468,506,917,491,744,1091,1051,594,465,850,338,417,320,1160,364,480,855,86,305,225,833,637,760,1147,613,236,460,664,1183,38,806,100,654,852,975,816,506,1092,275,6,229,972,53,554,370,63,651,701,304,1011,672,353,118,1111,448,549,151,1087,909,420,1095,663,1119,1124,729,578,733,861,1154,1195,387,1182,850,189,463,1129,1185,541,546,1159,314,137,479,59,841,514,548,496,642,341,151,999,1036,1186,704,550,1039,723,779,584,382,371,712,176,665,180,440,697,1102,408,728,157,1050,558,692,336,384,107,839,477,204,862,345,429,1144,1069,207,449,594,963,988,843,334,200,865,281,296,1040,914,995,743,1134,1050,484,602,1001,570,1052,1106,922,77,1099,681,360,955,1184,669,411,760,46,599,815,231,86,694,469,1079,1161,1105,519,1010,681,603,376,534,145,361,448,1006,91,397,671,597,238,119,467,587,723,162,804,638,568,195,460,610,868,806,995,1178,490,406,933,232,17,37,2,114,1004,871,531,209,267,37,750,1196,940,89,725,377,898,6,685,210,1127,1160,432,391,931,681,937,275,1190,137,743,652,430,566,180,1192,718,253,133,998,1067,764,747,1159,827,143,506,641,327,468,731,50,15,569,80,310,1086,1092,989,245,520,711,788,1144,938,1152,1169,563,1053,1182,331,838,112,361,1049,717,979,956,434,534,1083,117,280,1104,293,1137,592,1019,606,526,216,924,197,137,1041,2,910,274,1178,267,521,626,764,691,124,446,337,676,325,288,1120,924,512,777,1063,979,86,677,1183,777,418,41,852,929,712,1132,1030,339,943,475,851,340,894,1091,230,654,229,945,69,182,110,255,895,645,1061,793,1016,807,440,330,519,73,108,660,209,1077,1191,938,415,1162,579,258,14,273,561,834,371,134,1118,1139,1163,667,979,483,436,42,593,139,846,875,571,808,76,713,1198,352,299,156,793,509,245,697,1106,236,287,236,644,683},
                new int[]{319,178,37,756,152,763,481,1055,594,825,759,494,1087,696,717,358,1091,1145,1043,245,779,957,3,1060,1141,926,226,657,869,740,1170,746,889,416,634,209,1189,1076,819,1144,40,807,561,400,283,133,186,839,1043,491,936,559,70,9,854,1172,9,739,871,436,1087,1029,66,561,798,1141,701,1020,1072,92,636,509,392,77,84,202,843,563,329,906,101,997,1162,105,876,460,285,446,753,516,60,932,323,659,9,639,1041,861,1199,343,792,1114,536,405,542,805,929,589,538,410,143,114,24,1064,682,536,1016,1141,843,472,817,196,673,189,915,196,755,203,956,283,833,836,22,899,232,655,572,207,819,639,1024,887,407,385,251,896,165,290,193,357,870,678,411,697,998,344,628,866,1004,894,547,574,36,847,691,601,896,363,21,1133,115,658,855,1042,2,189,230,215,747,971,581,809,832,311,35,639,1127,701,167,672,763,997,1061,1170,289,806,91,198,720,67,273,863,437,152,671,635,968,107,58,453,392,236,875,719,44,850,176,580,937,227,125,851,1188,915,747,1175,69,743,250,275,290,787,780,516,775,279,256,649,83,1180,372,655,813,750,381,807,988,977,430,282,1067,551,726,756,372,17,1016,550,1128,223,174,85,1039,1,27,178,822,243,440,79,772,211,640,454,1141,654,351,54,794,711,157,492,307,1156,937,212,461,417,741,1104,642,1147,833,1194,1066,1070,876,1045,341,854,1014,787,518,404,1068,385,756,998,298,439,917,183,71,363,38,828,372,1071,195,481,1153,871,712,803,849,145,1144,410,420,561,678,241,498,548,436,871,810,180,635,119,665,551,1132,807,408,685,489,274,459,28,987,935,310,284,1163,924,812,267,1123,782,1065,1075,1199,1047,289,280,1044,931,1056,625,672,150,41,1084,998,151,483,226,548,277,1187,1010,262,1048,493,1084,845,1127,1009,773,129,547,798,118,559,463,972,666,1155,519,381,405,819,201,790,729,1100,614,691,3,386,206,514,387,612,1073,158,67,1116,164,496,1056,1159,348,530,28,1177,774,1139,559,563,310,916,897,36,1060,173,952,123,635,911,711,304,611,481,645,532,1033,385,402,797,117,307,969,1147,1127,434,1099,1043,104,74,257,778,934,901,106,84,525,138,698,877,1009,487,450,649,736,802,1032,456,757,10,2,720,1155,234,844,880,1053,1134,821,1094,970,1095,976,101,1163,104,38,198,350,896,345,867,1129,1064,403,228,1103,416,561,722,915,1161,252,45,632,1163,232,174,964,876,1126,479,432,984,815,544,1005,620,497,1021,763,169,1028,706,1112,150,368,483,251,721,492,686,1105,38,1140,1085,153,366,428,296,28,648,873,21,236,393,581,1043,1086,747,402,201,1196,416,788,318,257,815,735,1023,1143,1100,922,1033,884,824,963,159,904,21,1168,511,723,400,239,338,89,1099,572,674,54,891,426,277,91,504,302,616,468,506,917,491,744,1091,1051,594,465,850,338,417,320,1160,364,480,855,86,305,225,833,637,760,1147,613,236,460,664,1183,38,806,100,654,852,975,816,506,1092,275,6,229,972,53,554,370,63,651,701,304,1011,672,353,118,1111,448,549,151,1087,909,420,1095,663,1119,1124,729,578,733,861,1154,1195,387,1182,850,189,463,1129,1185,541,546,1159,314,137,479,59,841,514,548,496,642,341,151,999,1036,1186,704,550,1039,723,779,584,382,371,712,176,665,180,440,697,1102,408,728,157,1050,558,692,336,384,107,839,477,204,862,345,429,1144,1069,207,449,594,963,988,843,334,200,865,281,296,1040,914,995,743,1134,1050,484,602,1001,570,1052,1106,922,77,1099,681,360,955,1184,669,411,760,46,599,815,231,86,694,469,1079,1161,1105,519,1010,681,603,376,534,145,361,448,1006,91,397,671,597,238,119,467,587,723,162,804,638,568,195,460,610,868,806,995,1178,490,406,933,232,17,37,2,114,1004,871,531,209,267,37,750,1196,940,89,725,377,898,6,685,210,1127,1160,432,391,931,681,937,275,1190,137,743,652,430,566,180,1192,718,253,133,998,1067,764,747,1159,827,143,506,641,327,468,731,50,15,569,80,310,1086,1092,989,245,520,711,788,1144,938,1152,1169,563,1053,1182,331,838,112,361,1049,717,979,956,434,534,1083,117,280,1104,293,1137,592,1019,606,526,216,924,197,137,1041,2,910,274,1178,267,521,626,764,691,124,446,337,676,325,288,1120,924,512,777,1063,979,86,677,1183,777,418,41,852,929,712,1132,1030,339,943,475,851,340,894,1091,230,654,229,945,69,182,110,255,895,645,1061,793,1016,807,440,330,519,73,108,660,209,1077,1191,938,415,1162,579,258,14,273,561,834,371,134,1118,1139,1163,667,979,483,436,42,593,139,846,875,571,808,76,713,1198,352,299,156,793,509,245,697,1106,236,287,236,644,683}));
    }
}