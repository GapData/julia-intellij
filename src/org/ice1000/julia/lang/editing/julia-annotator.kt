package org.ice1000.julia.lang.editing

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import org.ice1000.julia.lang.JuliaHighlighter
import org.ice1000.julia.lang.psi.*

class JuliaAnnotator : Annotator {
	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when (element) {
			is JuliaTypeName -> holder.createInfoAnnotation(element, null)
					.textAttributes = JuliaHighlighter.TYPE_NAME
			is JuliaFunctionName -> holder.createInfoAnnotation(element, null)
					.textAttributes = JuliaHighlighter.FUNCTION_NAME
			is JuliaAbstractTypeName -> holder.createInfoAnnotation(element, null)
					.textAttributes = JuliaHighlighter.ABSTRACT_TYPE_NAME
			is JuliaModuleName -> holder.createInfoAnnotation(element, null)
					.textAttributes = JuliaHighlighter.MODULE_NAME
			is JuliaInteger -> {
				holder.createWarningAnnotation(element, "integer")
			}
			is JuliaFloat -> {
				holder.createInfoAnnotation(element, "float")
			}
			is JuliaString -> {
				holder.createInfoAnnotation(element, " string ♂ ")
			}
			is JuliaFunction -> {
				holder.createInfoAnnotation(element, "FuncDef")
			}
			is JuliaIf -> {
				holder.createInfoAnnotation(element, "if statement `if x < y ` ")
			}
			is JuliaFor -> {
				holder.createInfoAnnotation(element, "for statement format: `for i in `")
			}
			is JuliaWhile -> {

			}
			is JuliaTypeName->{
				println(element)
				holder.createInfoAnnotation(element, "A type name")
			}
			is JuliaSymbol->{
				println(element.text)
				holder.createInfoAnnotation(element, "A symbol")
			}
		}
	}
}