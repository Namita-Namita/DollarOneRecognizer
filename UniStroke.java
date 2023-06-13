/*
 * @author Namita Namita
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Unistorke class to save the templates and use them for recognizer
public class UniStroke {
  List<Gesture> template;

  public UniStroke() {
    template = new ArrayList<>();

    // triangle template
    Point[] point0 = { new Point(137, 139, 0), new Point(135, 141, 0), new Point(133, 144, 0), new Point(132, 146, 0),
        new Point(130, 149, 0), new Point(128, 151,0), new Point(126, 155,0), new Point(123, 160,0),
        new Point(120, 166,0), new Point(116, 171,0), new Point(112, 177,0), new Point(107, 183,0),
        new Point(102, 188,0), new Point(100, 191,0), new Point(95, 195,0), new Point(90, 199,0),
        new Point(86, 203,0), new Point(82, 206,0), new Point(80, 209,0), new Point(75, 213,0),
        new Point(73, 213,0), new Point(70, 216, 0), new Point(67, 219,0), new Point(64, 221,0),
        new Point(61, 223,0), new Point(60, 225,0), new Point(62, 226, 0), new Point(65, 225,0),
        new Point(67, 226,0), new Point(74, 226,0), new Point(77, 227,0), new Point(85, 229,0),
        new Point(91, 230,0), new Point(99, 231,0), new Point(108, 232,0), new Point(116, 233,0),
        new Point(125, 233,0), new Point(134, 234,0), new Point(145, 233,0), new Point(153, 232,0),
        new Point(160, 233,0), new Point(170, 234,0), new Point(177, 235,0), new Point(179, 236,0),
        new Point(186, 237,0), new Point(193, 238,0), new Point(198, 239,0), new Point(200, 237,0),
        new Point(202, 239,0), new Point(204, 238,0), new Point(206, 234,0), new Point(205, 230,0),
        new Point(202, 222, 0), new Point(197, 216,0), new Point(192, 207,0), new Point(186, 198,0),
        new Point(179, 189, 0), new Point(174, 183, 0), new Point(170, 178, 0), new Point(164, 171, 0),
        new Point(161, 168, 0), new Point(154, 160, 0), new Point(148, 155, 0), new Point(143, 150, 0),
        new Point(138, 148,0), new Point(136, 148,0) };
    AddTemplate("triangle", point0);

    // x template
    Point[] point1 = { new Point(87, 142,0), new Point(89, 145,0), new Point(91, 148,0), new Point(93, 151, 0),
        new Point(96, 155,0), new Point(98, 157,0), new Point(100, 160,0), new Point(102, 162,0),
        new Point(106, 167,0), new Point(108, 169,0), new Point(110, 171,0), new Point(115, 177,0),
        new Point(119, 183,0), new Point(123, 189,0), new Point(127, 193,0), new Point(129, 196,0),
        new Point(133, 200,0), new Point(137, 206,0), new Point(140, 209,0), new Point(143, 212,0),
        new Point(146, 215,0), new Point(151, 220,0), new Point(153, 222,0), new Point(155, 223,0),
        new Point(157, 225,0), new Point(158, 223,0), new Point(157, 218,0), new Point(155, 211,0),
        new Point(154, 208,0), new Point(152, 200,0), new Point(150, 189,0), new Point(148, 179,0),
        new Point(147, 170,0), new Point(147, 158,0), new Point(147, 148,0), new Point(147, 141,0),
        new Point(147, 136,0), new Point(144, 135,0), new Point(142, 137,0), new Point(140, 139,0),
        new Point(135, 145,0), new Point(131, 152,0), new Point(124, 163,0), new Point(116, 177,0),
        new Point(108, 191,0), new Point(100, 206,0), new Point(94, 217,0), new Point(91, 222,0),
        new Point(89, 225,0), new Point(87, 226,0), new Point(87, 224,0) };
    AddTemplate("x", point1);

    // rectangle template
    Point[] point2 = { new Point(78, 149, 0), new Point(78, 153, 0), new Point(78, 157, 0), new Point(78, 160, 0),
        new Point(79, 162, 0), new Point(79, 164, 0), new Point(79, 167, 0), new Point(79, 169, 0),
        new Point(79, 173, 0), new Point(79, 178, 0), new Point(79, 183, 0), new Point(80, 189, 0),
        new Point(80, 193, 0), new Point(80, 198, 0), new Point(80, 202, 0), new Point(81, 208, 0),
        new Point(81, 210, 0), new Point(81, 216, 0), new Point(82, 222, 0), new Point(82, 224, 0),
        new Point(82, 227, 0), new Point(83, 229, 0), new Point(83, 231, 0), new Point(85, 230, 0),
        new Point(88, 232, 0), new Point(90, 233, 0), new Point(92, 232, 0), new Point(94, 233, 0),
        new Point(99, 232, 0), new Point(102, 233, 0), new Point(106, 233, 0), new Point(109, 234, 0),
        new Point(117, 235, 0), new Point(123, 236, 0), new Point(126, 236, 0), new Point(135, 237, 0),
        new Point(142, 238, 0), new Point(145, 238, 0), new Point(152, 238, 0), new Point(154, 239, 0),
        new Point(165, 238, 0), new Point(174, 237, 0), new Point(179, 236, 0), new Point(186, 235, 0),
        new Point(191, 235, 0), new Point(195, 233, 0), new Point(197, 233, 0), new Point(200, 233, 0),
        new Point(201, 235, 0), new Point(201, 233, 0), new Point(199, 231, 0), new Point(198, 226, 0),
        new Point(198, 220, 0), new Point(196, 207, 0), new Point(195, 195, 0), new Point(195, 181, 0),
        new Point(195, 173, 0), new Point(195, 163, 0), new Point(194, 155, 0), new Point(192, 145, 0),
        new Point(192, 143, 0), new Point(192, 138, 0), new Point(191, 135, 0), new Point(191, 133, 0),
        new Point(191, 130, 0), new Point(190, 128, 0), new Point(188, 129, 0), new Point(186, 129, 0),
        new Point(181, 132, 0), new Point(173, 131, 0), new Point(162, 131, 0), new Point(151, 132, 0),
        new Point(149, 132, 0), new Point(138, 132, 0), new Point(136, 132, 0), new Point(122, 131, 0),
        new Point(120, 131, 0), new Point(109, 130, 0), new Point(107, 130, 0), new Point(90, 132, 0),
        new Point(81, 133, 0), new Point(76, 133, 0) };
    AddTemplate("rectangle", point2);

    // circle template
    Point[] point3 = { new Point(127, 141, 0), new Point(124, 140, 0), new Point(120, 139, 0), new Point(118, 139, 0),
        new Point(116, 139, 0), new Point(111, 140, 0), new Point(109, 141, 0), new Point(104, 144, 0),
        new Point(100, 147,0), new Point(96, 152,0), new Point(93, 157,0), new Point(90, 163, 0),
        new Point(87, 169,0), new Point(85, 175,0), new Point(83, 181,0), new Point(82, 190, 0),
        new Point(82, 195,0), new Point(83, 200,0), new Point(84, 205,0), new Point(88, 213, 0),
        new Point(91, 216,0), new Point(96, 219,0), new Point(103, 222,0), new Point(108, 224, 0),
        new Point(111, 224,0), new Point(120, 224,0), new Point(133, 223,0), new Point(142, 222,0),
        new Point(152, 218,0), new Point(160, 214,0), new Point(167, 210,0), new Point(173, 204,0),
        new Point(178, 198,0), new Point(179, 196,0), new Point(182, 188,0), new Point(182, 177,0),
        new Point(178, 167,0), new Point(170, 150,0), new Point(163, 138,0), new Point(152, 130,0),
        new Point(143, 129,0), new Point(140, 131,0), new Point(129, 136,0), new Point(126, 139,0) };

    AddTemplate("circle", point3);

    // check template
    Point[] point4 = { new Point(91, 185,0), new Point(93, 185,0), new Point(95, 185,0), new Point(97, 185,0),
        new Point(100, 188,0),
        new Point(102, 189,0), new Point(104, 190,0), new Point(106, 193,0), new Point(108, 195,0), new Point(110, 198,0),
        new Point(112, 201,0), new Point(114, 204,0), new Point(115, 207,0), new Point(117, 210,0), new Point(118, 212,0),
        new Point(120, 214,0), new Point(121, 217,0), new Point(122, 219,0), new Point(123, 222,0), new Point(124, 224,0),
        new Point(126, 226,0), new Point(127, 229,0), new Point(129, 231,0), new Point(130, 233,0), new Point(129, 231,0),
        new Point(129, 228,0), new Point(129, 226,0), new Point(129, 224,0), new Point(129, 221,0), new Point(129, 218,0),
        new Point(129, 212,0), new Point(129, 208,0), new Point(130, 198,0), new Point(132, 189,0), new Point(134, 182,0),
        new Point(137, 173,0), new Point(143, 164,0), new Point(147, 157,0), new Point(151, 151,0), new Point(155, 144,0),
        new Point(161, 137,0), new Point(165, 131,0), new Point(171, 122,0), new Point(174, 118,0), new Point(176, 114,0),
        new Point(177, 112,0), new Point(177, 114,0), new Point(175, 116,0), new Point(173, 118,0) };
    AddTemplate("check", point4);

    // caret template
    Point[] point5 = { new Point(79, 245,0), new Point(79, 242,0), new Point(79, 239,0), new Point(80, 237,0),
        new Point(80, 234,0),
        new Point(81, 232,0), new Point(82, 230,0), new Point(84, 224,0), new Point(86, 220,0), new Point(86, 218,0),
        new Point(87, 216,0), new Point(88, 213,0), new Point(90, 207,0), new Point(91, 202,0), new Point(92, 200,0),
        new Point(93, 194,0), new Point(94, 192,0), new Point(96, 189,0), new Point(97, 186,0), new Point(100, 179,0),
        new Point(102, 173,0), new Point(105, 165,0), new Point(107, 160,0), new Point(109, 158,0), new Point(112, 151,0),
        new Point(115, 144,0), new Point(117, 139,0), new Point(119, 136,0), new Point(119, 134,0), new Point(120, 132,0),
        new Point(121, 129,0), new Point(122, 127,0), new Point(124, 125,0), new Point(126, 124,0), new Point(129, 125,0),
        new Point(131, 127,0), new Point(132, 130,0), new Point(136, 139,0), new Point(141, 154,0), new Point(145, 166,0),
        new Point(151, 182,0), new Point(156, 193,0), new Point(157, 196,0), new Point(161, 209,0), new Point(162, 211,0),
        new Point(167, 223,0), new Point(169, 229,0), new Point(170, 231,0), new Point(173, 237,0), new Point(176, 242,0),
        new Point(177, 244,0), new Point(179, 250,0), new Point(181, 255,0), new Point(182, 257,0) };
    AddTemplate("caret", point5);

    // zigzag template
    Point[] point6 = { new Point(307, 216,0), new Point(333, 186,0), new Point(356, 215,0), new Point(375, 186,0),
        new Point(399, 216,0), new Point(418, 186,0) };
    AddTemplate("zigzag", point6);

    // arrow template
    Point[] point7 = { new Point(68, 222,0), new Point(70, 220,0), new Point(73, 218,0), new Point(75, 217,0),
        new Point(77, 215,0), new Point(80, 213,0), new Point(82, 212,0), new Point(84, 210,0), new Point(87, 209,0),
        new Point(89, 208,0), new Point(92, 206,0), new Point(95, 204,0), new Point(101, 201,0), new Point(106, 198,0),
        new Point(112, 194,0), new Point(118, 191,0), new Point(124, 187,0), new Point(127, 186,0), new Point(132, 183,0),
        new Point(138, 181,0), new Point(141, 180,0), new Point(146, 178,0), new Point(154, 173,0), new Point(159, 171,0),
        new Point(161, 170,0), new Point(166, 167,0), new Point(168, 167,0), new Point(171, 166,0), new Point(174, 164,0),
        new Point(177, 162,0), new Point(180, 160,0), new Point(182, 158,0), new Point(183, 156,0), new Point(181, 154,0),
        new Point(178, 153,0), new Point(171, 153,0), new Point(164, 153,0), new Point(160, 153,0), new Point(150, 154,0),
        new Point(147, 155,0), new Point(141, 157,0), new Point(137, 158,0), new Point(135, 158,0), new Point(137, 158,0),
        new Point(140, 157,0), new Point(143, 156,0), new Point(151, 154,0), new Point(160, 152,0), new Point(170, 149,0),
        new Point(179, 147,0), new Point(185, 145,0), new Point(192, 144,0), new Point(196, 144,0), new Point(198, 144,0),
        new Point(200, 144,0), new Point(201, 147,0), new Point(199, 149,0), new Point(194, 157,0), new Point(191, 160,0),
        new Point(186, 167,0), new Point(180, 176,0), new Point(177, 179,0), new Point(171, 187,0), new Point(169, 189,0),
        new Point(165, 194,0), new Point(164, 196,0) };
    AddTemplate("arrow", point7);

    // left square bracket template
    Point[] point8 = { new Point(140, 124,0), new Point(138, 123,0), new Point(135, 122,0), new Point(133, 123,0),
        new Point(130, 123,0), new Point(128, 124,0), new Point(125, 125,0), new Point(122, 124,0), new Point(120, 124,0),
        new Point(118, 124,0), new Point(116, 125,0), new Point(113, 125,0), new Point(111, 125,0), new Point(108, 124,0),
        new Point(106, 125,0), new Point(104, 125,0), new Point(102, 124,0), new Point(100, 123,0), new Point(98, 123,0),
        new Point(95, 124,0), new Point(93, 123,0), new Point(90, 124,0), new Point(88, 124,0), new Point(85, 125,0),
        new Point(83, 126,0), new Point(81, 127,0), new Point(81, 129,0), new Point(82, 131,0), new Point(82, 134,0),
        new Point(83, 138,0), new Point(84, 141,0), new Point(84, 144,0), new Point(85, 148,0), new Point(85, 151,0),
        new Point(86, 156,0), new Point(86, 160,0), new Point(86, 164,0), new Point(86, 168,0), new Point(87, 171,0),
        new Point(87, 175,0), new Point(87, 179,0), new Point(87, 182,0), new Point(87, 186,0), new Point(88, 188,0),
        new Point(88, 195,0), new Point(88, 198,0), new Point(88, 201,0), new Point(88, 207,0), new Point(89, 211,0),
        new Point(89, 213,0), new Point(89, 217,0), new Point(89, 222,0), new Point(88, 225,0), new Point(88, 229,0),
        new Point(88, 231,0), new Point(88, 233,0), new Point(88, 235,0), new Point(89, 237,0), new Point(89, 240,0),
        new Point(89, 242,0), new Point(91, 241,0), new Point(94, 241,0), new Point(96, 240,0), new Point(98, 239,0),
        new Point(105, 240,0), new Point(109, 240,0), new Point(113, 239,0), new Point(116, 240,0), new Point(121, 239,0),
        new Point(130, 240,0), new Point(136, 237,0), new Point(139, 237,0), new Point(144, 238,0), new Point(151, 237,0),
        new Point(157, 236,0), new Point(159, 237,0) };
    AddTemplate("left square bracket", point8);

    // right square bracket template
    Point[] point9 = { new Point(112, 138,0), new Point(112, 136,0), new Point(115, 136,0), new Point(118, 137,0),
        new Point(120, 136,0), new Point(123, 136,0), new Point(125, 136,0), new Point(128, 136,0), new Point(131, 136,0),
        new Point(134, 135,0), new Point(137, 135,0), new Point(140, 134,0), new Point(143, 133,0), new Point(145, 132,0),
        new Point(147, 132,0), new Point(149, 132,0), new Point(152, 132,0), new Point(153, 134,0), new Point(154, 137,0),
        new Point(155, 141,0), new Point(156, 144,0), new Point(157, 152,0), new Point(158, 161,0), new Point(160, 170,0),
        new Point(162, 182,0), new Point(164, 192,0), new Point(166, 200,0), new Point(167, 209,0), new Point(168, 214,0),
        new Point(168, 216,0), new Point(169, 221,0), new Point(169, 223,0), new Point(169, 228,0), new Point(169, 231,0),
        new Point(166, 233,0), new Point(164, 234,0), new Point(161, 235,0), new Point(155, 236,0), new Point(147, 235,0),
        new Point(140, 233,0), new Point(131, 233,0), new Point(124, 233,0), new Point(117, 235,0), new Point(114, 238,0),
        new Point(112, 238,0) };
    AddTemplate("right square bracket", point9);

    // v template
    Point[] point10 = { new Point(89, 164,0), new Point(90, 162,0), new Point(92, 162,0), new Point(94, 164,0),
        new Point(95, 166,0), new Point(96, 169,0), new Point(97, 171,0), new Point(99, 175,0), new Point(101, 178,0),
        new Point(103, 182,0), new Point(106, 189,0), new Point(108, 194,0), new Point(111, 199,0), new Point(114, 204,0),
        new Point(117, 209,0), new Point(119, 214,0), new Point(122, 218,0), new Point(124, 222,0), new Point(126, 225,0),
        new Point(128, 228,0), new Point(130, 229,0), new Point(133, 233,0), new Point(134, 236,0), new Point(136, 239,0),
        new Point(138, 240,0), new Point(139, 242,0), new Point(140, 244,0), new Point(142, 242,0), new Point(142, 240,0),
        new Point(142, 237,0), new Point(143, 235,0), new Point(143, 233,0), new Point(145, 229,0), new Point(146, 226,0),
        new Point(148, 217,0), new Point(149, 208,0), new Point(149, 205,0), new Point(151, 196,0), new Point(151, 193,0),
        new Point(153, 182,0), new Point(155, 172,0), new Point(157, 165,0), new Point(159, 160,0), new Point(162, 155,0),
        new Point(164, 150,0), new Point(165, 148,0), new Point(166, 146,0) };
    AddTemplate("v", point10);

    // delete template
    Point[] point11 = { new Point(123, 129,0), new Point(123, 131,0), new Point(124, 133,0), new Point(125, 136,0),
        new Point(127, 140,0), new Point(129, 142,0), new Point(133, 148,0), new Point(137, 154,0), new Point(143, 158,0),
        new Point(145, 161,0), new Point(148, 164,0), new Point(153, 170,0), new Point(158, 176,0), new Point(160, 178,0),
        new Point(164, 183,0), new Point(168, 188,0), new Point(171, 191,0), new Point(175, 196,0), new Point(178, 200,0),
        new Point(180, 202,0), new Point(181, 205,0), new Point(184, 208,0), new Point(186, 210,0), new Point(187, 213,0),
        new Point(188, 215,0), new Point(186, 212,0), new Point(183, 211,0), new Point(177, 208,0), new Point(169, 206,0),
        new Point(162, 205,0), new Point(154, 207,0), new Point(145, 209,0), new Point(137, 210,0), new Point(129, 214,0),
        new Point(122, 217,0), new Point(118, 218,0), new Point(111, 221,0), new Point(109, 222,0), new Point(110, 219,0),
        new Point(112, 217,0), new Point(118, 209,0), new Point(120, 207,0), new Point(128, 196,0), new Point(135, 187,0),
        new Point(138, 183,0), new Point(148, 167,0), new Point(157, 153,0), new Point(163, 145,0), new Point(165, 142,0),
        new Point(172, 133,0), new Point(177, 127,0), new Point(179, 127,0), new Point(180, 125,0) };
    AddTemplate("delete", point11);

    // left curly brace template
    Point[] point12 = { new Point(150, 116,0), new Point(147, 117,0), new Point(145, 116,0), new Point(142, 116,0),
        new Point(139, 117,0), new Point(136, 117,0), new Point(133, 118,0), new Point(129, 121,0), new Point(126, 122,0),
        new Point(123, 123,0), new Point(120, 125,0), new Point(118, 127,0), new Point(115, 128,0), new Point(113, 129,0),
        new Point(112, 131,0), new Point(113, 134,0), new Point(115, 134,0), new Point(117, 135,0), new Point(120, 135,0),
        new Point(123, 137,0), new Point(126, 138,0), new Point(129, 140,0), new Point(135, 143,0), new Point(137, 144,0),
        new Point(139, 147,0), new Point(141, 149,0), new Point(140, 152,0), new Point(139, 155,0), new Point(134, 159,0),
        new Point(131, 161,0), new Point(124, 166,0), new Point(121, 166,0), new Point(117, 166,0), new Point(114, 167,0),
        new Point(112, 166,0), new Point(114, 164,0), new Point(116, 163,0), new Point(118, 163,0), new Point(120, 162,0),
        new Point(122, 163,0), new Point(125, 164,0), new Point(127, 165,0), new Point(129, 166,0), new Point(130, 168,0),
        new Point(129, 171,0), new Point(127, 175,0), new Point(125, 179,0), new Point(123, 184,0), new Point(121, 190,0),
        new Point(120, 194,0), new Point(119, 199,0), new Point(120, 202,0), new Point(123, 207,0), new Point(127, 211,0),
        new Point(133, 215,0), new Point(142, 219,0), new Point(148, 220,0), new Point(151, 221,0) };
    AddTemplate("left curly brace", point12);

    // right curly brace template
    Point[] point13 = { new Point(117, 132,0), new Point(115, 132,0), new Point(115, 129,0), new Point(117, 129,0),
        new Point(119, 128,0), new Point(122, 127,0), new Point(125, 127,0), new Point(127, 127,0), new Point(130, 127,0),
        new Point(133, 129,0), new Point(136, 129,0), new Point(138, 130,0), new Point(140, 131,0), new Point(143, 134,0),
        new Point(144, 136,0), new Point(145, 139,0), new Point(145, 142,0), new Point(145, 145,0), new Point(145, 147,0),
        new Point(145, 149,0), new Point(144, 152,0), new Point(142, 157,0), new Point(141, 160,0), new Point(139, 163,0),
        new Point(137, 166,0), new Point(135, 167,0), new Point(133, 169,0), new Point(131, 172,0), new Point(128, 173,0),
        new Point(126, 176,0), new Point(125, 178,0), new Point(125, 180,0), new Point(125, 182,0), new Point(126, 184,0),
        new Point(128, 187,0), new Point(130, 187,0), new Point(132, 188,0), new Point(135, 189,0), new Point(140, 189,0),
        new Point(145, 189,0), new Point(150, 187,0), new Point(155, 186,0), new Point(157, 185,0), new Point(159, 184,0),
        new Point(156, 185,0), new Point(154, 185,0), new Point(149, 185,0), new Point(145, 187,0), new Point(141, 188,0),
        new Point(136, 191,0), new Point(134, 191,0), new Point(131, 192,0), new Point(129, 193,0), new Point(129, 195,0),
        new Point(129, 197,0), new Point(131, 200,0), new Point(133, 202,0), new Point(136, 206,0), new Point(139, 211,0),
        new Point(142, 215,0), new Point(145, 220,0), new Point(147, 225,0), new Point(148, 231,0), new Point(147, 239,0),
        new Point(144, 244,0), new Point(139, 248,0), new Point(134, 250,0), new Point(126, 253,0), new Point(119, 253,0),
        new Point(115, 253,0) };
    AddTemplate("right curly brace", point13);

    // star template
    Point[] point14 = { new Point(75, 250,0), new Point(75, 247,0), new Point(77, 244,0), new Point(78, 242,0),
        new Point(79, 239,0), new Point(80, 237,0), new Point(82, 234,0), new Point(82, 232,0), new Point(84, 229,0),
        new Point(85, 225,0), new Point(87, 222,0), new Point(88, 219,0), new Point(89, 216,0), new Point(91, 212,0),
        new Point(92, 208,0), new Point(94, 204,0), new Point(95, 201,0), new Point(96, 196,0), new Point(97, 194,0),
        new Point(98, 191,0), new Point(100, 185,0), new Point(102, 178,0), new Point(104, 173,0), new Point(104, 171,0),
        new Point(105, 164,0), new Point(106, 158,0), new Point(107, 156,0), new Point(107, 152,0), new Point(108, 145,0),
        new Point(109, 141,0), new Point(110, 139,0), new Point(112, 133,0), new Point(113, 131,0), new Point(116, 127,0),
        new Point(117, 125,0), new Point(119, 122,0), new Point(121, 121,0), new Point(123, 120,0), new Point(125, 122,0),
        new Point(125, 125,0), new Point(127, 130,0), new Point(128, 133,0), new Point(131, 143,0), new Point(136, 153,0),
        new Point(140, 163,0), new Point(144, 172,0), new Point(145, 175,0), new Point(151, 189,0), new Point(156, 201,0),
        new Point(161, 213,0), new Point(166, 225,0), new Point(169, 233,0), new Point(171, 236,0), new Point(174, 243,0),
        new Point(177, 247,0), new Point(178, 249,0), new Point(179, 251,0), new Point(180, 253,0), new Point(180, 255,0),
        new Point(179, 257,0), new Point(177, 257,0), new Point(174, 255,0), new Point(169, 250,0), new Point(164, 247,0),
        new Point(160, 245,0), new Point(149, 238,0), new Point(138, 230,0), new Point(127, 221,0), new Point(124, 220,0),
        new Point(112, 212,0), new Point(110, 210,0), new Point(96, 201,0), new Point(84, 195,0), new Point(74, 190,0),
        new Point(64, 182,0), new Point(55, 175,0), new Point(51, 172,0), new Point(49, 170,0), new Point(51, 169,0),
        new Point(56, 169,0), new Point(66, 169,0), new Point(78, 168,0), new Point(92, 166,0), new Point(107, 164,0),
        new Point(123, 161,0), new Point(140, 162,0), new Point(156, 162,0), new Point(171, 160,0), new Point(173, 160,0),
        new Point(186, 160,0), new Point(195, 160,0), new Point(198, 161,0), new Point(203, 163,0), new Point(208, 163,0),
        new Point(206, 164,0), new Point(200, 167,0), new Point(187, 172,0), new Point(174, 179,0), new Point(172, 181,0),
        new Point(153, 192,0), new Point(137, 201,0), new Point(123, 211,0), new Point(112, 220,0), new Point(99, 229,0),
        new Point(90, 237,0), new Point(80, 244,0), new Point(73, 250,0), new Point(69, 254,0), new Point(69, 252,0) };
    AddTemplate("star", point14);

    // pig tail template
    Point[] point15 = { new Point(81, 219,0), new Point(84, 218,0), new Point(86, 220,0), new Point(88, 220,0),
        new Point(90, 220,0), new Point(92, 219,0), new Point(95, 220,0), new Point(97, 219,0), new Point(99, 220,0),
        new Point(102, 218,0), new Point(105, 217,0), new Point(107, 216,0), new Point(110, 216,0), new Point(113, 214,0),
        new Point(116, 212,0), new Point(118, 210,0), new Point(121, 208,0), new Point(124, 205,0), new Point(126, 202,0),
        new Point(129, 199,0), new Point(132, 196,0), new Point(136, 191,0), new Point(139, 187,0), new Point(142, 182,0),
        new Point(144, 179,0), new Point(146, 174,0), new Point(148, 170,0), new Point(149, 168,0), new Point(151, 162,0),
        new Point(152, 160,0), new Point(152, 157,0), new Point(152, 155,0), new Point(152, 151,0), new Point(152, 149,0),
        new Point(152, 146,0), new Point(149, 142,0), new Point(148, 139,0), new Point(145, 137,0), new Point(141, 135,0),
        new Point(139, 135,0), new Point(134, 136,0), new Point(130, 140,0), new Point(128, 142,0), new Point(126, 145,0),
        new Point(122, 150,0), new Point(119, 158,0), new Point(117, 163,0), new Point(115, 170,0), new Point(114, 175,0),
        new Point(117, 184,0), new Point(120, 190,0), new Point(125, 199,0), new Point(129, 203,0), new Point(133, 208,0),
        new Point(138, 213,0), new Point(145, 215,0), new Point(155, 218,0), new Point(164, 219,0), new Point(166, 219,0),
        new Point(177, 219,0), new Point(182, 218,0), new Point(192, 216,0), new Point(196, 213,0), new Point(199, 212,0),
        new Point(201, 211,0) };

    AddTemplate("pigtail", point15);
  }
  // Method to add templates for the recognizer to match with
//   public void AddTemplate(String s, Point[] p) {
//    List<Point> points = new ArrayList<>(Arrays.asList(p));
//     // Resampling of the templates saved
//    List<Point> resampledPoints = resample(points);

//     // Rotating the points of the tempates saved
//     //Finding the centroid of the templates one by one
//     Point centroid = centroid(resampledPoints);
//     // Fetching the start point for roation
//     Point firstPoint = resampledPoints.get(0);
//     // Calculating the slope to rotate the templates to a certain angle.
//     double slope = Math.atan2((firstPoint.y - centroid.y), (firstPoint.x - centroid.x));
//     List<Point> rotatedPoints = rotateBy(resampledPoints, -1 * slope, centroid);

//     Gesture g = new Gesture(rotatedPoints, s);
//     this.template.add(g);
//   }
  public void AddTemplate(String s, Point[] p) {
    PointProcessor pointProcessor = new PointProcessor();
    ArrayList<Point> points = new ArrayList<>(Arrays.asList(p));
    // Resampling of the templates saved
    ArrayList<Point> resampledPoints = pointProcessor.resample(points);

    // Rotating the points of the tempates saved
    //Finding the centroid of the templates one by one
    Point centroid = pointProcessor.centroid(resampledPoints);
    // Fetching the start point for roation
    Point firstPoint = resampledPoints.get(0);
    // Calculating the slope to rotate the templates to a certain angle.
    double slope = Math.atan2((firstPoint.y - centroid.y), (firstPoint.x - centroid.x));
    ArrayList<Point> rotatedPoints = PointProcessor.rotateBy(resampledPoints, -1 * slope, centroid);

    // Scaling the tempates one by one
    pointProcessor.scale(rotatedPoints);

    // Translating the templates one by one
    ArrayList<Point> translatedPoints = pointProcessor.translate(rotatedPoints);

    Gesture g = new Gesture(translatedPoints, s);
    this.template.add(g);
  }

}

class Gesture {
  public final List<Point> points;
  public final String name;

  public Gesture(List<Point> points, String name) {
    this.points = points;
    this.name = name;
  }

  public Gesture(List<Point> points) {
    this(points, "");
  }
  // Point class with values x and y to store x and y coordinates.
// public class Point
// {
// 	public double x, y;
// 	// default constructor
// 	public Point(){
// 		this.x = 0; this.y = 0;
// 	}
// 	//constructor to assign x and y values.
// 	public Point(double x, double y)
// 	{	this.x = x; this.y = y;	}
// 	// distance method to calculate distance between two points x and y
// 	public double distance( Point other)
//   {
//     return Math.sqrt(Math.pow(other.x-x,2)+Math.pow(other.y-y ,2));
//   }

}
